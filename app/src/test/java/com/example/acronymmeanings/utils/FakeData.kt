package com.example.acronymmeanings.utils

import com.example.acronymmeanings.models.FullForm
import com.example.acronymmeanings.models.LongFormDetails
import com.example.acronymmeanings.models.Meaning

class FakeData {
    companion object{
        fun getData():List<Meaning>{
            val details1 = LongFormDetails("National Aeronautics and Space Administration",81,1982)
            val details2 = LongFormDetails("National Aeronautic and Space Administration",2,1992)
            val details3 = LongFormDetails("National Aeronautics and Space administration",1,2000)
            val fullForm = FullForm("National Aeronautics and Space Administration",84,1982, listOf(details1,details2,details3))

            return listOf(Meaning("NASA", listOf(fullForm)))
        }
    }
}