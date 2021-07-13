package com.lehlagoo.legods

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.lehlagoo.legods.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkIfPrimaryButtonIsClickableAndIsDisplayed() {
        onView(withId(R.id.buttom_primary)).perform(click())
        onView(withId(R.id.buttom_primary)).check(matches(isDisplayed()))
    }

    fun checkIfSecondaryButtonIsClickableAndIsDisplayed() {
        onView(withId(R.id.buttom_secondary)).perform(click())
        onView(withId(R.id.buttom_secondary)).check(matches(isDisplayed()))
    }

}