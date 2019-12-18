package com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.testing.SingleFragmentActivity;
import com.dicoding.picodiploma.mybottomnavigation.utils.EspressoIdlingResource;
import com.dicoding.picodiploma.mybottomnavigation.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FaveMovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FaveMovieFragment faveMovieFragment = new FaveMovieFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(faveMovieFragment);
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_fave_movie_list)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fave_movie_list)).check(new RecyclerViewItemCountAssertion(0));
    }
}