package com.moonpi.swiftnotes;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.moonpi.swiftnotes.MainActivity;
import com.moonpi.swiftnotes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class SampleTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void javaExampleTest() {
        onView(ViewMatchers.withId(com.moonpi.swiftnotes.R.id.newNote)).perform(click());
        onView(allOf(ViewMatchers.withId(com.moonpi.swiftnotes.R.id.titleEdit), isDisplayed())).check(matches(withHint("Title")));
        onView(allOf(ViewMatchers.withId(R.id.bodyEdit), isDisplayed())).check(matches(withHint("Note")));

    }
}
