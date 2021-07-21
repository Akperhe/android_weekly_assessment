package com.smith.getandpostapp

import com.smith.getandpostapp.dataClass.ItemsItem
import com.smith.getandpostapp.dataClass.StudentsItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Services {
    @GET("items")
    suspend fun getAllItems(): List<ItemsItem>

    @POST("students")
    fun postStudent(@Body studentsItem: StudentsItem): Call<StudentsItem>
    //ruuning on a separate couroutine enqued

}