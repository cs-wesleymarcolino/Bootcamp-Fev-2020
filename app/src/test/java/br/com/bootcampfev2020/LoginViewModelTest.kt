package br.com.bootcampfev2020

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mockedPasswordValidator = mockk<PasswordValidator>()
    private val loginViewModel = LoginViewModel(
        mockedPasswordValidator
    )

    @Test
    fun givenInvalidPassword_whenValidatingPassword_shouldEmitError() {
        every { mockedPasswordValidator.isValid(any()) } returns false

        loginViewModel.validateLogin("email", "senha")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.Error(R.string.generic_error)
        )
    }

    @Test
    fun givenValidPassword_whenValidatingPassword_shouldEmitNavigateToHome() {
        every { mockedPasswordValidator.isValid(any()) } returns true

        loginViewModel.validateLogin("email", "senha")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.NavigateToHome
        )
    }
}