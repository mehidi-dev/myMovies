package com.mehidiahmed.mymovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mehidiahmed.mymovies.model.Movie
import com.mehidiahmed.mymovies.repository.MoviesRepository
import kotlinx.coroutines.*

class FirstFragmentViewModel : ViewModel() {

    private val movies = liveData(Dispatchers.IO) {
        val popularMovie = MoviesRepository.getMovies().movies
        emit(popularMovie)
    }

    fun getMovie(): LiveData<List<Movie>> {
        return movies
    }
}