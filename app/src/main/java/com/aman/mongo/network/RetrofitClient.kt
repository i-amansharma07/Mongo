package com.aman.mongo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://salty-journey-42535.herokuapp.com/api/"

class RetrofitClient {

    private val retrofitClient = null

    fun getInstance():Retrofit{
        if(retrofitClient != null){
            return retrofitClient!!
        }else{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}

