package com.a203110017.annisakinnti_retrofit2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.a203110017.annisakinnti_retrofit2.databinding.AdapterMovieBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    // mengembalikan mutablelist movie
    var movies = mutableListOf<Movie>()

    // melakukan set list movie
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    // untuk binding ke adaptor
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
// membangun reqest data dari client
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
       holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)

    }

    // menghitung jumlah movie
    override fun getItemCount(): Int {
        return movies.size
    }
}

// untuk mengatur view holder
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
