// AuthRepository.kt
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun login(username: String, password: String): Result<LoginResponse> {
        return withContext(Dispatchers.IO) {
            try {
//                val loginRequest = LoginRequest(username, password)
                val loginRequest = Login("1MUlgViu5Oxbo+x6yZkW84TbbV176O324GsrnMCxfbaOnswYm/g2XZi43MWZ3DxVFPXUzol6nI8meYzAQoPo4GNRu+0CypjKbz6lQRLopyA=")
                val response = apiService.trueLogin(loginRequest)

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.success) {
                        Result.success(loginResponse)
                    } else {
                        Result.failure(Exception(loginResponse?.message ?: "登录失败"))
                    }
                } else {
                    Result.failure(Exception("HTTP错误: ${response.code()}"))
                }
            } catch (e: Exception) {
                Log.e("TAG",e.message.toString())
                Result.failure(Exception("网络请求失败: ${e.message}"))
            }
        }
    }
}