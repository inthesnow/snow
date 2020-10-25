package com.example.mycarad.data

import java.io.Serializable

data class AdvisorReadDto(
        val response : List<AdvisorReadInfo>
) : Serializable

data class AdvisorReadInfo(
        val idx : String,
        val title :String,
        val userName : String,
        val adbName : String,
        val area : String,
        val carkind :String,
        val connect :String,
        val detail : String,
        val date : String
)
