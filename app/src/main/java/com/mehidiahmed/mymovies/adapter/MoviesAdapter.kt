package com.mehidiahmed.mymovies.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mehidiahmed.mymovies.FirstFragmentDirections
import com.mehidiahmed.mymovies.R
import com.mehidiahmed.mymovies.databinding.ItemMovieBinding
import com.mehidiahmed.mymovies.model.Movie

class MoviesAdapter(
    private var movies: MutableList<Movie>
 ) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }


    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesAdapter.MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.item = movie
            Glide.with(itemView)
                .load("http://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(binding.itemMoviePoster)

            binding.root.setOnClickListener{
                val direction = FirstFragmentDirections.actionFirstFragmentToDetailFragment(movie)
                binding.root.findNavController().navigate(direction)
                Log.i("MoviesAdapter", movie.title)
            }
        }
    }
}