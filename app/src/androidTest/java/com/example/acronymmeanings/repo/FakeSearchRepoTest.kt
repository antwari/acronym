package com.example.acronymmeanings.repo

import com.example.acronymmeanings.Utils.Resource
import com.example.acronymmeanings.uiUtils.FakeDataTest
import com.example.acronymmeanings.models.Meaning

class FakeSearchRepoTest : Search {
    private val data: List<Meaning> = FakeDataTest.getData()

    override suspend fun fetchMeanings(acronym: String): Resource<List<Meaning>> {
        return Resource.success(data)
    }
}