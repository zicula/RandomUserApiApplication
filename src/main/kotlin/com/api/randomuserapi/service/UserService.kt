package com.api.randomuserapi.service

import com.api.randomuserapi.model.User
import com.api.randomuserapi.model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
open class UserService(private val restTemplate: RestTemplate) {

    fun getRandomUser(seed: String): User {
        val uri = UriComponentsBuilder.fromHttpUrl("https://randomuser.me/api/")
            .queryParam("seed", seed)
            .toUriString()

        val response: ResponseEntity<UserResponse> = restTemplate.getForEntity(uri, UserResponse::class.java)

        return response.body?.results?.map {
            User(
                firstname = it.name.first,
                lastname = it.name.last,
                gender = it.gender,
                email = it.email
            )
        }?.first() ?: throw Exception(">>> Failed to fetch user data")
    }
}