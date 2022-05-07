package com.aman.mongo.network

import com.aman.mongo.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {
    @GET("user")
    fun getSuperHeroes(): Call<List<Model>>
}