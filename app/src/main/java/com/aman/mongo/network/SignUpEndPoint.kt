package com.aman.mongo.network

import com.aman.mongo.model.SignUpModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpEndPoint {
    @POST("signup")
    fun sendUser(@Body model: SignUpModel): Call<SignUpModel>
//    fun sendUser(model: SignUpModel): Call<SignUpModel>
}