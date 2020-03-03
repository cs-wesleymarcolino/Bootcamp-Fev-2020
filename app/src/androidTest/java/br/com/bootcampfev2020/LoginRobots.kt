@file:Suppress("ClassName")

package br.com.bootcampfev2020

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers

class loginArrange(action: loginArrange.() -> Unit) {
    fun mockHomeActivityIntent() {
        intending(IntentMatchers.hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }

    init {
        action.invoke(this)
    }
}

class loginAct(action: loginAct.() -> Unit) {

    init {
        action.invoke(this)
    }

    fun typeEmail(email: String) {
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText(email))
    }

    fun typePassword(password: String) {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText(password))
    }

    fun clickLogin() {
        Espresso.onView(ViewMatchers.withId(R.id.login))
            .perform(ViewActions.click())
    }

}

class loginAssert(action: loginAssert.() -> Unit) {

    init {
        action.invoke(this)
    }

    fun checkEmailIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkPasswordIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkErrorIsShown(@StringRes errorRes: Int) {
        Espresso.onView(ViewMatchers.withText(errorRes))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkHomeActivityWasStarted() {
        Intents.intended(IntentMatchers.hasComponent(HomeActivity::class.java.name))
    }

}
