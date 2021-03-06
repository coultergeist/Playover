package com.playover;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.playover.viewmodels.AuthUserViewModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class MessagingThreadsTest {

    private static AuthUserViewModel authUserViewModel = new AuthUserViewModel();
    private Intent testIntent;
    private List<String> testMessagingList = new ArrayList<String>();

    @Rule
    public ActivityTestRule<MessagingActivity> activityTestRule =
            new ActivityTestRule<MessagingActivity>(MessagingActivity.class, true, false) {
                @Override
                protected Intent getActivityIntent() {
                    testIntent = new Intent();
                    return testIntent;
                }
            };

    private boolean checkForUser() {
        return (authUserViewModel.getUser() != null);
    }

    @Test
    public void testMessagingThreads() {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            onView(MainActivityTest.withRecyclerView(R.id.recycler_view).atPosition(1))
                    .check(matches(hasDescendant(withText("Mel Tassone"))));
        }
    }


    @Test
    public void testMessagingDrawerMessaging() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_messaging));
            Espresso.pressBack();
        }
    }
    @Test
    public void testMessagingDrawerProfile() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Espresso.pressBack();
        }
    }
    @Test
    public void testMessagingDrawerCheckin() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_check_in));
            Espresso.pressBack();
        }
    }
    @Test
    public void testMessagingDrawerSettings() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_settings));
            Espresso.pressBack();
        }
    }
    @Test
    public void testMessagingDrawerBuddies() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            Espresso.pressBack();
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_buddies));
            Espresso.pressBack();
        }
    }
    @Test
    public void testMessagingDrawerDiscounts() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_discounts));
            Espresso.pressBack();
        }
    }

    @Test
    public void testMessagingDrawerSignOut() throws InterruptedException {
        if (checkForUser()) {
            activityTestRule.launchActivity(testIntent);
            Thread.sleep(2000);
            onView(withId(R.id.messaging_content)).check(matches(isDisplayed()));
            onView(withId(R.id.messaging_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view_messaging)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(2000);
            onView(withId(R.id.lblogin_main)).perform(MainActivityTest.clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(replaceText("melsmail@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(replaceText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(5000);
            if (MainActivityTest.withRecyclerView(R.id.recycler_view).atPosition(0).matches(isDisplayed())) {
                onView(MainActivityTest.withRecyclerView(R.id.recycler_view).atPosition(0))
                        .check(matches(isDisplayed()));
            }
        }
    }

}
