package com.smith.getandpostapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val services: Services = retrofit.create(Services::class.java)

}