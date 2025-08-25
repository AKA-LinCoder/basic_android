// ApiService.kt
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("api/user/login")
    suspend fun trueLogin(@Body loginRequest: Login): Response<LoginResponse>
}