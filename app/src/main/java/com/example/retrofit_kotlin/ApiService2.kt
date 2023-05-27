package com.example.retrofit_kotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiService2 {
    @GET ("character")
    fun getRick(): Call<Responsemorty>
}