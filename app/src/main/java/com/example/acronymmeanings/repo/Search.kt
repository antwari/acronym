package com.example.acronymmeanings.repo

import com.example.acronymmeanings.Utils.Resource
import com.example.acronymmeanings.models.Meaning

interface Search {
    suspend fun fetchMeanings(acronym: String) : Resource<List<Meaning>>
}