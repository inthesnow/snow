package com.example.mycarad.data

import java.io.Serializable

data class DriverReadDto(
        val response2 : List<DriverReadInfo>
) : Serializable

data class DriverReadInfo(
        val idx : String,
        val title :String,
        val userName : String,
        val carName : String,
        val carKind :String,
        val connect :String,
        val detail : String,
        val date : String,
        val tuneContent : String
)
