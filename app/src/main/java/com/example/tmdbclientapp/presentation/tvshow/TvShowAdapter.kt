package com.example.tmdbclientapp.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclientapp.R
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.databinding.ListItemBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    private val callback = object: DiffUtil.ItemCallback<TvShow>(){
        override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow){
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item, parent, false) )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tvShow = differ.currentList[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}