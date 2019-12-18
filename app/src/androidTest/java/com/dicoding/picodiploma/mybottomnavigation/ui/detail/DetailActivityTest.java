package com.dicoding.picodiploma.mybottomnavigation.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.utils.EspressoIdlingResource;
import com.dicoding.picodiploma.mybottomnavigation.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {

    private MovieEntity dummyMovie;

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);
            dummyMovie = FakeDataDummy.generateDummyMovies().get(0);
            result.putExtra("MOVIE", dummyMovie);
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_item_name)).check(matches(withText(dummyMovie.getName())));
        onView(withId(R.id.tv_item_desc)).check(matches(withText(dummyMovie.getDescription())));
        onView(withId(R.id.tv_item_rating)).check(matches(withText(dummyMovie.getRating())));
        onView(withId(R.id.tv_item_year)).check(matches(withText(dummyMovie.getReleaseYear())));
    }
}