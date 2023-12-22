package com.example.uibasics

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("todos/")
    fun fetchFruits(): Call<List<FruitsModel>>
}