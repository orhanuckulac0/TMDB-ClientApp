package com.example.tmdbclientapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclientapp.R
import com.example.tmdbclientapp.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    @Inject lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel : MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        binding.movieRecyclerView.adapter = movieAdapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this){
            if (it!= null){
                movieAdapter.differ.submitList(it)
                binding.movieProgressBar.visibility = View.GONE
            }else{
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }
        binding.movieProgressBar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.actionUpdate -> {
                updateMovies()
                binding.movieRecyclerView.layoutManager?.scrollToPosition(0)
                true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.updateMovies()

        responseLiveData.observe(this){
            if (it != null){
                movieAdapter.differ.submitList(it)
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        }
        binding.movieProgressBar.visibility = View.GONE
    }
}