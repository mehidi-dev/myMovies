package com.mehidiahmed.mymovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mehidiahmed.mymovies.model.Movie

@Suppress("unchecked_cast")
class DetailFragmentViewModelFactory(private val movies: Movie) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFragmentViewModel::class.java)) {
            return DetailFragmentViewModel(movies) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}