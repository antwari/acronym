package com.example.acronymmeanings.repo

import com.example.acronymmeanings.Utils.Resource
import com.example.acronymmeanings.utils.FakeData
import com.example.acronymmeanings.models.Meaning

class FakeSearchRepo : Search {
    private val data: List<Meaning> = FakeData.getData()

    override suspend fun fetchMeanings(acronym: String): Resource<List<Meaning>> {
        return Resource.success(data)
    }
}