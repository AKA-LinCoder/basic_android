import com.google.android.material.color.utilities.Variant

// LoginRequest.kt
data class LoginRequest(
    val username: String,
    val password: String
)

// LoginResponse.kt
data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String?,
    val user: User?,
    val data: TrueLoginRes
)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String
)

data class Login(
    val rtnVal: String
)

data class TrueLoginRes(
    val isModify: String,
    val token: String
)