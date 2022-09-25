package com.mehidiahmed.mymovies.repository

import okhttp3.OkHttpClient
import com.mehidiahmed.mymovies.retrofit.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesRepository {
    private val api: Api
    private val apiKey: String = "c9856d0cb57c3f14bf75bdc6c063b8f3"

    init {
        var client = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    suspend fun getMovies() = api.getMovies(apiKey = apiKey, page = 1)

}
