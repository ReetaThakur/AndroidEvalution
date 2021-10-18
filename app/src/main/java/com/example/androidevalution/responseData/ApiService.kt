package com.example.androidevalution.responseData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("people")
    fun getInstance(@Query("page")page:Int):Call<List<ResponseModel>>
}