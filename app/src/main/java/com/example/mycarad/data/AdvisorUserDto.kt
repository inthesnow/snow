package com.example.mycarad.data
import java.io.Serializable


data class AdvisorUserDto(
        val response : List<AdvisorUserInfo>
) : Serializable

data class AdvisorUserInfo(
        val userId : String,
        val userPassword :String,
        val userName : String,
        val advName : String,
)