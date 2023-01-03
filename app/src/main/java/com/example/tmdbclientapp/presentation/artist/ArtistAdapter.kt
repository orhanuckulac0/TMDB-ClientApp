package com.example.tmdbclientapp.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclientapp.R
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.databinding.ListItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.MyViewHolder>(){

    private val callback = object : DiffUtil.ItemCallback<Artist>(){
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(artist: Artist){
            binding.titleTextView.text = artist.name
            binding.descriptionTextView.text = "Popularity:"+" "+artist.popularity.toString()
            val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val artist = differ.currentList[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}