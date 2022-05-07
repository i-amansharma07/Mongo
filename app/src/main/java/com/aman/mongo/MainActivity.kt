package com.aman.mongo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aman.mongo.adapter.Adapter
import com.aman.mongo.model.Model
import com.aman.mongo.network.EndPoints

import com.aman.mongo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*
    1. create the model class.
    2. create retrofit class : This Java class is used to send requests to an API. We specify the
                               URL that contains the data required and use the Retrofit Builder class.


 */

class MainActivity : AppCompatActivity() {
    private lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recycleView)
        get()
        
    }

    private fun get() {
        val call: Call<List<Model>> = RetrofitClient().getInstance().create(EndPoints::class.java).getSuperHeroes()
        call.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                val myheroList: List<Model> = response.body()!!
                rv.adapter = Adapter(myheroList)
            }
            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}

