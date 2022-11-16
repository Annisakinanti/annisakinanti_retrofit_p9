package com.a203110017.annisakinnti_retrofit2

class MainRepository constructor(private val retrofitService: RetrofitService) {
// mengambil data semua movie
    fun getAllMovies() = retrofitService.getAllMovies()
}