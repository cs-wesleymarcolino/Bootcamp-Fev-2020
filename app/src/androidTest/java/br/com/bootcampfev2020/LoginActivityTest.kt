package br.com.bootcampfev2020

import android.app.Activity
import android.app.Instrumentation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityTest = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPassword() {
        onView(withId(R.id.email))
            .check(matches(withText("")))
        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError() {
        onView(withId(R.id.password))
            .perform(typeText("aBcd1!2323dkj"))
        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.empty_email_error))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError() {
        onView(withId(R.id.email))
            .perform(typeText("w.jonathan.marcolino@concrete.com.br"))
        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.empty_password_error))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowInvalidPasswordError() {
        onView(withId(R.id.email))
            .perform(typeText("w.jonathan.marcolino@concrete.com.br"))
        onView(withId(R.id.password))
            .perform(typeText("abbbbbdkA"))
        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.invalid_password_error))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenEmailAndPasswordAreValid_whenLogin_shouldGoToHomeScreen() {
        intending(hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))

        onView(withId(R.id.email))
            .perform(typeText("w.jonathan.marcolino@concrete.com.br"))
        onView(withId(R.id.password))
            .perform(typeText("aBb3!@bdkA"))
        onView(withId(R.id.login))
            .perform(click())

        intended(hasComponent(HomeActivity::class.java.name))
    }
}