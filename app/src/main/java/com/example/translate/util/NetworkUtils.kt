package com.example.translate.util

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkUtils {

    companion object {
        var gson = GsonBuilder()
            .setLenient()
            .create()

        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    }
}