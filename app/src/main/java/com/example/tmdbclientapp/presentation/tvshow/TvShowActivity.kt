package com.example.tmdbclientapp.presentation.tvshow

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
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.databinding.ActivityTvShowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowActivity : AppCompatActivity() {
    @Inject lateinit var tvShowViewModelFactory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        tvShowViewModel = ViewModelProvider(this, tvShowViewModelFactory)[TvShowViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView(){
        tvShowAdapter = TvShowAdapter()
        binding.rvTvShow.adapter = tvShowAdapter
        binding.rvTvShow.layoutManager = LinearLayoutManager(this)
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.progressBarTvShow.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShow()

        responseLiveData.observe(this){
            if (it != null){
                tvShowAdapter.differ.submitList(it)
                binding.progressBarTvShow.visibility = View.GONE
            }else{
                Toast.makeText(this, "Error occurred, please refresh.", Toast.LENGTH_LONG).show()
                binding.progressBarTvShow.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.actionUpdate -> {
                updateTvShows()
                binding.rvTvShow.scrollToPosition(0)
                true
            }else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateTvShows() {
        binding.progressBarTvShow.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.updateTvShow()

        responseLiveData.observe(this){
            if (it != null){
                tvShowAdapter.differ.submitList(it)
                binding.progressBarTvShow.visibility = View.GONE
            }else{
                Toast.makeText(this, "Error occurred, please refresh.", Toast.LENGTH_LONG).show()
                binding.progressBarTvShow.visibility = View.GONE
            }
        }
    }
}