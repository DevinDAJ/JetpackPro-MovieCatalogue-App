package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow;

import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.testing.SingleFragmentActivity;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie.FaveMovieFragment;
import com.dicoding.picodiploma.mybottomnavigation.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FaveShowFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FaveShowFragment faveShowFragment = new FaveShowFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(faveShowFragment);
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_fave_show_list)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fave_show_list)).check(new RecyclerViewItemCountAssertion(0));
    }
}