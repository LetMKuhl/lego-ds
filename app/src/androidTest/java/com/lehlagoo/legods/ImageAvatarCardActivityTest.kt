@file:Suppress("DEPRECATION")

package com.lehlagoo.legods

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.lehlagoo.legods.view.ImageAvatarCardActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImageAvatarCardActivityTest {

    @get:Rule
    val rule = ActivityTestRule(ImageAvatarCardActivity::class.java)

    @Test
    fun checkIfButtonFollowAndUnfollowChangesButtonStateAndText() {
        onView(withId(R.id.follow_button)).perform(click())
            .check(matches(withText(R.string.unfollow_status)))

        onView(withId(R.id.follow_button)).perform(click())
            .check(matches(withText(R.string.follow_button)))
    }

}