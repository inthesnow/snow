package com.example.mycarad.data

import java.io.Serializable

data class AdvisorReadDto(
        val response2 : List<AdvisorReadInfo>
) : Serializable

data class AdvisorReadInfo(
        val idx : String,
        val title : String,
        val userName : String,
        val advName : String,
        val area : String,
        val carKind : String,
        val connect : String,
        val detail : String,
        val date : String,
        val cost : String = "1000"
)
