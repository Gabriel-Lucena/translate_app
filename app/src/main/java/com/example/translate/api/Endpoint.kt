package com.example.translate.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("{portuguese_word}")
    fun getEnglishWord(
        @Path(value = "portuguese_word") english_word: String
    ): Call<String>

}