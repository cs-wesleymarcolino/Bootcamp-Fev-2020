package br.com.bootcampfev2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val passwordValidator: PasswordValidator
) : ViewModel() {
    private val state = MutableLiveData<LoginViewState>()

    fun getViewState(): LiveData<LoginViewState> = state

    fun validateLogin(
        email: String,
        password: String
    ) {
        val isValid = passwordValidator.isValid(password)

        if (isValid) {
            state.value = LoginViewState.NavigateToHome
        } else {
            state.value = LoginViewState.Error(R.string.generic_error)
        }
    }
}
