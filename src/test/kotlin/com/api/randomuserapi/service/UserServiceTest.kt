import com.api.randomuserapi.model.Name
import com.api.randomuserapi.model.User
import com.api.randomuserapi.model.UserResponse
import com.api.randomuserapi.model.UserResult
import com.api.randomuserapi.service.UserService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class UserServiceTest {
    private val mockRestTemplate = Mockito.mock(RestTemplate::class.java)
    private val userService = UserService(mockRestTemplate)

    @Test
    fun `getRandomUser returns user`() {
        // Given
        val seed = "test1"
        val expectedUserResult = UserResult(
            name = Name("", "Bratko", "Slivenko"),
            gender = "Male",
            email = "bratko.slivenko@example.com"
        )
        val expectedUser = User(
            firstname = "Bratko",
            lastname = "Slivenko",
            gender = "Male",
            email = "bratko.slivenko@example.com"
        )
        val userResponse = UserResponse(listOf(expectedUserResult))
        val responseEntity = ResponseEntity(userResponse, HttpStatus.OK)

        Mockito.`when`(
            mockRestTemplate.getForEntity(
                "https://randomuser.me/api/?seed=$seed",
                UserResponse::class.java
            )
        ).thenReturn(responseEntity)

        // When
        val result = userService.getRandomUser(seed)

        // Then
        assertEquals(expectedUser, result)
    }
}