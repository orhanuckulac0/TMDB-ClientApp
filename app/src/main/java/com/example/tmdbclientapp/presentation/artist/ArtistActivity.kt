package com.example.tmdbclientapp.presentation.artist

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
import com.example.tmdbclientapp.databinding.ActivityArtistBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistActivity : AppCompatActivity() {
    @Inject lateinit var artistViewModelFactory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var artistAdapter: ArtistAdapter
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        artistViewModel = ViewModelProvider(this, artistViewModelFactory)[ArtistViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvArtist.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        binding.rvArtist.adapter = artistAdapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.progressBarArtist.visibility = View.VISIBLE

        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this){
            if (it != null){
                val sortedList = it.sortedByDescending {artist->
                    artist.popularity
                }
                artistAdapter.differ.submitList(sortedList)
            }else{
                Toast.makeText(this, "An error occurred, please refresh.", Toast.LENGTH_LONG).show()
            }
        }
        binding.progressBarArtist.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.actionUpdate -> {
                updateArtists()
                binding.rvArtist.layoutManager?.scrollToPosition(0)
                true
            }else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateArtists() {
        binding.progressBarArtist.visibility = View.VISIBLE

        val responseLiveData = artistViewModel.updateArtists()

        responseLiveData.observe(this){
            if (it != null){
                val sortedList = it.sortedByDescending {artist->
                    artist.popularity
                }
                artistAdapter.differ.submitList(sortedList)
            }else{
                Toast.makeText(this, "An error occurred, please refresh.", Toast.LENGTH_LONG).show()
            }
        }
        binding.progressBarArtist.visibility = View.GONE
    }
}