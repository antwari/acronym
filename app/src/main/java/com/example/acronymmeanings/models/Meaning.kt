package com.example.acronymmeanings.models

import com.squareup.moshi.Json


data class Meaning(
    @Json(name = "sf")
    val abbreviation: String? = null,
    @Json(name = "lfs")
    val fullForms: List<FullForm>
)

data class FullForm(
    @Json(name = "lf")
    val longForm: String? = null,
    @Json(name = "freq")
    val frequencies: Int,
    val since: Int,
    @Json(name = "vars")
    val details: List<LongFormDetails>

)

data class LongFormDetails(
    @Json(name = "lf")
    val longForm: String? = null,
    @Json(name = "freq")
    val frequencies: Int,
    val since: Int
)