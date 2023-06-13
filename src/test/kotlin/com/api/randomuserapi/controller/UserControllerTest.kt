package com.api.randomuserapi.controller

import com.api.randomuserapi.model.User
import com.api.randomuserapi.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.client.HttpClientErrorException

@ExtendWith(MockitoExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var userService: UserService

    @InjectMocks
    lateinit var userController: UserController

    private val userSeed = "test1"
    private val user = User(
        firstname = "Bratko",
        lastname = "Slivenko",
        gender = "Male",
        email = "bratko.slivenko@example.com"
    )

    @BeforeEach
    fun setUp() {
        Mockito.`when`(userService.getRandomUser(userSeed)).thenReturn(user)
    }

//    @Test
//    fun `Test Get Random User`() {
//        mockMvc.perform(get("/v1/users/$userSeed")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//    }
//
//    @Test
//    fun `Test Get Random User not found`() {
//        Mockito.`when`(userService.getRandomUser("notfound")).thenThrow(HttpClientErrorException.NotFound::class.java)
//
//        mockMvc.perform(get("/v1/users/notfound")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound)
//    }
}
