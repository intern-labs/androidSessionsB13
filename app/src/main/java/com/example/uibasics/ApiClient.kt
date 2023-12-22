package com.example.uibasics

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Using Object to create a Singleton instance of ApiClient
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Accessing retrofit using this field would ensure that the same instance of retrofit would be
    // used through out the app.
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
