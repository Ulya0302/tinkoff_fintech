@file:JvmName("Checkers")
package com.moonpi.swiftnotes.util

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import org.hamcrest.Matchers.allOf

fun checkTextWithText(elementID: Int, text : String) =
        onView(allOf<View>(withText(elementID), isDisplayed()))
            .check(matches(withText(text)))

fun checkHintWithId(elementID: Int, text: String) =
        onView(allOf<View>(withId(elementID), isDisplayed()))
                .check(matches(withHint(text)))

fun checkEnabledByID(elementID: Int) =
        onView(withId(elementID))
                .check(matches(isEnabled()))

fun checkEnabledWithText(elementID: Int) =
        onView(withText(elementID))
                .check(matches(isEnabled()))

fun checkDisplayedWithText(elementID: Int) =
        onView(withText(elementID))
                .check(matches(isDisplayed()))


fun clickWithId(elementID: Int) =
        onView(allOf<View>(withId(elementID), isEnabled()))
            .perform(click())


fun typeString(elementID: Int, text: String) =
        onView(allOf<View>(withId(elementID), isDisplayed()))
                .perform(click())
                .perform(typeText(text))