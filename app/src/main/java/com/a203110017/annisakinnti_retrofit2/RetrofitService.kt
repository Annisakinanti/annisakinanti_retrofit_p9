package com.a203110017.annisakinnti_retrofit2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
// mengambil list movie dalam format JSON
    @GET("movielist.json")
    fun getAllMovies() : Call<List<Movie>>

    companion object {

        // menginisialisasi RetrofitService
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
// jika RetrofitService tidak bernilai, maka fungsi ini akan dijalankan
            if (retrofitService == null) {
                // mengambil data dari internet
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                // membangun API dengan RetrofitService
                retrofitService = retrofit.create(RetrofitService::class.java)
            }

            // mengembalikkan RetrofitService
            return retrofitService!!
        }
    }
}