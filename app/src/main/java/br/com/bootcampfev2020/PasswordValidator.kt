package br.com.bootcampfev2020

class PasswordValidator {
    private val validations = listOf(
        "[\\w\\W]{8,}",
        "[A-Z]",
        "[a-z]",
        "[\\d]",
        "[\\W]"
    ).map { it.toRegex() }

    fun validate(password: String) = validations.all { validation ->
        password.contains(validation)
    }
}
