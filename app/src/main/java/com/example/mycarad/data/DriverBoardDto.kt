package com.example.mycarad.data

import java.io.Serializable

data class DriverBoardDto(
        val response: List<DriverBoardInfo>
) : Serializable

data class DriverBoardInfo(
        val idx: String,
        val userName: String,
        val userPassword : String,
        val title: String,
        val content: String,
        val date: String

)