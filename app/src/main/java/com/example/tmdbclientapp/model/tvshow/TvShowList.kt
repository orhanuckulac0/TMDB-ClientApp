package com.example.tmdbclientapp.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val results: List<TvShow>,
)