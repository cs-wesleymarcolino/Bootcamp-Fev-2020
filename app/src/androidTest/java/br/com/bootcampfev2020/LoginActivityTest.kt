package br.com.bootcampfev2020

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityTest = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPassword() {
        loginAssert {
            checkEmailIsEmpty()
            checkPasswordIsEmpty()
        }
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError() {
        loginAct {
            typePassword("aBcd1!2323dkj")
            clickLogin()
        }

        loginAssert {
            checkErrorIsShown(R.string.generic_error)
        }
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError() {
        loginAct {
            typeEmail("w.jonathan.marcolino@concrete.com.br")
            clickLogin()
        }

        loginAssert {
            checkErrorIsShown(R.string.generic_error)
        }
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowInvalidPasswordError() {
        loginAct {
            typeEmail("w.jonathan.marcolino@concrete.com.br")
            typePassword("abbbbbdkA")
            clickLogin()
        }

        loginAssert {
            checkErrorIsShown(R.string.generic_error)
        }
    }

    @Test
    fun givenEmailAndPasswordAreValid_whenLogin_shouldGoToHomeScreen() {
        loginArrange {
            mockHomeActivityIntent()
        }

        loginAct {
            typeEmail("w.jonathan.marcolino@concrete.com.br")
            typePassword("aBb3!@bdkA")
            clickLogin()
        }

        loginAssert {
            checkHomeActivityWasStarted()
        }
    }
}