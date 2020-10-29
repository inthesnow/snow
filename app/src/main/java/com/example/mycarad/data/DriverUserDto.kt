package com.example.mycarad.data
import java.io.Serializable


data class DriverUserDto(
        val response : List<DriverUserInfo>
) : Serializable

data class DriverUserInfo(
        val userId : String,
        val userPassword :String,
        val userName : String,
        val carKind : String,
        val carName :String
)
