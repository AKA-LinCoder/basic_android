package com.echo.basicleaning

// LoginActivity.kt
import LoginResponse
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.echo.basicleaning.viewmodel.AuthViewModel
import com.echo.basicleaning.viewmodel.LoginState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
        observeLoginState()
    }

    private fun setupViews() {
        val loginButton = findViewById<Button>(R.id.loginButton)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInput(username, password)) {
                viewModel.login(username, password)
            }
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            showError("请输入用户名")
            return false
        }

        if (password.isEmpty()) {
            showError("请输入密码")
            return false
        }

        if (password.length < 6) {
            showError("密码长度不能少于6位")
            return false
        }

        hideError()
        return true
    }

    private fun observeLoginState() {
        lifecycleScope.launch {
            viewModel.loginState.collectLatest { state ->
                when (state) {
                    is LoginState.Idle -> {
                        hideLoading()
                        hideError()
                    }
                    is LoginState.Loading -> {
                        showLoading()
                        hideError()
                    }
                    is LoginState.Success -> {
                        hideLoading()
                        onLoginSuccess(state.loginResponse)
                    }
                    is LoginState.Error -> {
                        hideLoading()
                        showError(state.message)
                    }
                }
            }
        }
    }

    private fun onLoginSuccess(loginResponse: LoginResponse) {
        // 保存token到SharedPreferences或其他存储
        saveAuthToken(loginResponse.token)

        // 跳转到主页面
        Toast.makeText(this, "登录成功: ${loginResponse.user?.firstName}", Toast.LENGTH_SHORT).show()

        // 示例: 跳转到主页面
        // startActivity(Intent(this, MainActivity::class.java))
        // finish()
    }

    private fun saveAuthToken(token: String?) {
        token?.let {
            val sharedPref = getSharedPreferences("auth", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("token", token)
                apply()
            }
        }
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
        findViewById<Button>(R.id.loginButton).isEnabled = false
    }

    private fun hideLoading() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        findViewById<Button>(R.id.loginButton).isEnabled = true
    }

    private fun showError(message: String) {
        val errorTextView = findViewById<TextView>(R.id.errorTextView)
        errorTextView.text = message
        errorTextView.visibility = View.VISIBLE
    }

    private fun hideError() {
        findViewById<TextView>(R.id.errorTextView).visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.resetState()
    }
}