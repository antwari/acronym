package com.example.acronymmeanings.repo

import com.example.acronymmeanings.Utils.Resource
import com.example.acronymmeanings.Utils.Util
import com.example.acronymmeanings.models.Meaning

class SearchRepo : Search {

    override suspend fun fetchMeanings(acronym: String): Resource<List<Meaning>> {
        return try {
            val response = Util.injectRetrofitAPI().getMeanings(acronym)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error")
            } else {
                Resource.error("Error")
            }
        } catch (e: Exception) {
            Resource.error("No data!")
        }
    }


}