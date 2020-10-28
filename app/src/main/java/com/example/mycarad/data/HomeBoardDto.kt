package com.example.mycarad.data

import java.io.Serializable

data class HomeBoardDto(
        val response: List<HomeBoardInfo>
) : Serializable

data class HomeBoardInfo(
        val idx : String,
        val title : String,
        val date : String
)