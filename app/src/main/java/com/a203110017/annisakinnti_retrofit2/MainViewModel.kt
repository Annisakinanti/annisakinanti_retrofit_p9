package com.a203110017.annisakinnti_retrofit2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// memproses data yang di dapatkan dari UI dan di kembalikan lagi ke UI
class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    // untuk inisialisasi movielist dan error messege
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    // untuk megambil data semua movie
    fun getAllMovies() {

        // mengambil repository semua list movie
        val response = repository.getAllMovies()
        // mengirimkan request callback list movie
        response.enqueue(object : Callback<List<Movie>> {
            // mengembalikan respon , jika list berhasil diambil
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            // jika list gagal didapat, maka fungsi ini akan dijalankan
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}