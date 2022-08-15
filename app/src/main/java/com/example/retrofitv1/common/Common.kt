package com.example.retrofitv1.common

import com.example.retrofitv1.Retrofit.RetrofitClient
import com.example.retrofitv1.Retrofit.RetrofitService

object Common {
    val BASE_URL="https://newsapi.org/v2/"
    val retrofitService :RetrofitService
        get()= RetrofitClient.RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}