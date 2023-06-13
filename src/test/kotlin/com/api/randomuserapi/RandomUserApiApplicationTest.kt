package com.api.randomuserapi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate

@ExtendWith(SpringExtension::class)
@SpringBootTest
class RandomUserApiApplicationTest {
    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Test
    fun `RestTemplate Bean Creation Test`() {
        assertNotNull(restTemplate)
        assertNotNull(restTemplate.requestFactory)
    }
}