package com.example.mycarad.data

import java.io.Serializable

data class AdvisorBoardDto(
        val response: List<AdvisorBoardInfo>
) : Serializable

data class AdvisorBoardInfo(
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