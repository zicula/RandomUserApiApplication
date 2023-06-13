package com.api.randomuserapi.model

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class UserResult(
    val gender: String,
    val name: Name,
    val email: String
)