package com.example.mycarad.data
import java.io.Serializable


data class AdvisorUserDto(
        val response : List<DriverUserInfo>
) : Serializable

data class AdvisorUserInfo(
        val userId : String,
        val userPassword :String,
        val userName : String,
        val carKind : String,
        val carName :String,
        val carTune :String
)