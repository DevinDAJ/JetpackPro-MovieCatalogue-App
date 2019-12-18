package com.dicoding.picodiploma.mybottomnavigation;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.mybottomnavigation.main.MainActivity;
import com.dicoding.picodiploma.mybottomnavigation.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieCatalogueTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }
    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }
    @Test
    public void recyclerViewOnFragmentTest() {
        onView(withId(R.id.rv_movie_list)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
