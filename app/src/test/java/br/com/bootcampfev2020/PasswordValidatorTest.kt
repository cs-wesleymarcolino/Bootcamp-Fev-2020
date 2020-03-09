package br.com.bootcampfev2020

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordLengthIsShorterThan8_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("aB!4123")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveUppercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("abcd12@#")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveLowercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCD12@#")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveSpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCD12a4")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveANumber_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCD!as@")

        assertFalse(result)
    }

    @Test
    fun givenEmptyPassword_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = passwordValidator.isValid("ABCD2!as@")

        assertTrue(result)
    }
}