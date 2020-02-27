package br.com.bootcampfev2020

import org.junit.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest {
    @Test
    fun givenPasswordLengthIsShorterThan8_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().validate("1234567")

        assertFalse(result)
    }
}