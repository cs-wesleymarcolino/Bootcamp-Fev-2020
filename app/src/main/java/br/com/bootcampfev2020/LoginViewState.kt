package br.com.bootcampfev2020

sealed class LoginViewState {
    data class Error(val message: Int) : LoginViewState()
    object NavigateToHome : LoginViewState()
}
