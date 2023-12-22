package com.example.uibasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.Executors

class ListScreen : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_screen)

        // Layout manager
        // RecyclerView Adapter - To manager data
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        fetchFruits()
    }

    // For background thread:
    // 1. JAVA -> Thread class
    // 2. Android -> Executors, Coroutines, AsyncTask (deprecated)
    private fun fetchFruits() {
        // We provide our specific interface to this Retrofit client
        val apiInterface: ApiInterface = ApiClient.retrofit.create(ApiInterface::class.java)
        // Run on background thread
        apiInterface.fetchFruits().enqueue(
            object : Callback<List<FruitsModel>> {

                override fun onResponse(
                    call: Call<List<FruitsModel>>,
                    response: Response<List<FruitsModel>>
                ) {
                    try {
                        Executors.newSingleThreadExecutor().execute {
                            val listOfFruits: List<FruitsModel>? = call.clone().execute().body()
                            if (listOfFruits != null) {
                                runOnUiThread {
                                    recyclerView.adapter = FruitsAdapter(listOfFruits)
                                }
                            }
                        }
                    } catch (e: IOException) {
                        // Handle error. Show error on screen
                    }
                }

                override fun onFailure(call: Call<List<FruitsModel>>, t: Throwable) {
                    // Handle error. Show error on screen
                }
            }
        )
    }
}
