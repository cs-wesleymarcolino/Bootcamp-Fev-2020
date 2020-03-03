package br.com.bootcampfev2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            when {
                email.text.toString().isBlank() -> showError(R.string.empty_email_error)
                password.text.toString().isBlank() -> showError(R.string.empty_password_error)
                !passwordValidator.isValid(password.text.toString()) -> showError(R.string.invalid_password_error)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun showError(@StringRes errorRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorRes)
            .show()
    }
}