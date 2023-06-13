package com.api.randomuserapi.controller

import com.api.randomuserapi.model.User
import com.api.randomuserapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{seed}")
    fun getRandomUser(@PathVariable seed: String): ResponseEntity<User> {
        return try {
            val user = userService.getRandomUser(seed)
            ResponseEntity.ok(user)
        } catch (e: HttpClientErrorException) {
            ResponseEntity.notFound().build()
        }
    }
}
