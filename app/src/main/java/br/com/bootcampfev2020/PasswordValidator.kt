package br.com.bootcampfev2020

class PasswordValidator {
    fun validate(password: String): Boolean {
        return password.length >= 8
    }
}
