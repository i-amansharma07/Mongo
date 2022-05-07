package com.aman.mongo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://salty-journey-42535.herokuapp.com/api/"

class SignupClient {
    private val signupClient = null

    fun getInstance(): Retrofit {
        if(signupClient != null){
            return signupClient!!
        }else{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}