package com.example.acronymmeanings.Utils

import com.example.acronymmeanings.api.DictionaryApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Util {
    private const val BASE_URL = "http://www.nactem.ac.uk"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun injectRetrofitAPI(): DictionaryApi {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build().create(DictionaryApi::class.java)
    }
}