package com.example.acronymmeanings.api

import com.example.acronymmeanings.models.Meaning
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryApi {
    @GET("software/acromine/dictionary.py")
    suspend fun getMeanings(@Query("sf") abbreviation:String): Response<List<Meaning>>

}