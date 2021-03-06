package com.playover;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class ProfileTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class) {

    };

    @Test
    public void cantSaveChangesPosition() throws Exception {
        try {
            Thread.sleep(5000);
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);
            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            onView(withId(R.id.editPosition))
                    .perform(replaceText(""));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editPosition))
                    .check(matches(hasErrorText("Position is required!")));
        } catch (Exception ex) {
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);

            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            onView(withId(R.id.editPosition))
                    .perform(replaceText(""));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editPosition))
                    .check(matches(hasErrorText("First name is required!")));
        }
    }

    @Test
    public void cantSaveChangesLastName() throws Exception {
        try {
            Thread.sleep(5000);
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);

            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText(""));
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editLastName))
                    .check(matches(hasErrorText("Last name is required!")));
        } catch (Exception ex) {
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);

            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText(""));
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editLastName))
                    .check(matches(hasErrorText("Last name is required!")));
        }
    }

    @Test
    public void cantSaveChangesFirstName() throws Exception {
        try {
            Thread.sleep(5000);
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);

            onView(withId(R.id.editFirstName))
                    .perform(replaceText(""));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editFirstName))
                    .check(matches(hasErrorText("First name is required!")));
        } catch (Exception ex) {
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);

            onView(withId(R.id.editFirstName))
                    .perform(replaceText(""));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());

            onView(withId(R.id.editFirstName))
                    .check(matches(hasErrorText("First name is required!")));
        }
    }

    @Test
    public void testButtons() throws InterruptedException {
        Thread.sleep(5000);
        //if logged in, log out and perform test
        try {
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);
            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            closeSoftKeyboard();
            onView(withId(R.id.year)).perform(click());
            onData(allOf(is(instanceOf(Integer.class)))).atPosition(1).perform(click());
            onView(withId(R.id.month)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
            onView(withId(R.id.day)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
            onView(withId(R.id.relationship)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withId(R.id.editGroup))
                    .perform(replaceText("North Seattle"));
            closeSoftKeyboard();
            onView(withId(R.id.editInterests))
                    .perform(replaceText("Video Games"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());
            Thread.sleep(10000);
            onView(withId(R.id.profileName))
                    .check(matches(withText("Mikal Viencek")));
            onView(withId(R.id.profileGroup))
                    .check(matches(withText("North Seattle")));
            onView(withId(R.id.profileInterest))
                    .check(matches(withText("Video Games")));
            onView(withId(R.id.profilePosition))
                    .check(matches(withText("Technical Support Specialist")));
            onView(withId(R.id.profileRelationshipText))
                    .check(matches(withText("Married")));

        }
        //else perform test
        catch (Exception ex) {
            Thread.sleep(5000);
            onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
            onView(withId(R.id.email_login)).perform(typeText("mviencek@hotmail.com")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(8000);
            onView(withId(R.id.main_content)).check(matches(isDisplayed()));
            onView(withId(R.id.main_content)).perform(DrawerActions.open());
            onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
            Thread.sleep(5000);
            onView(withText("Edit"))
                    .perform(click());
            Thread.sleep(10000);
            onView(withId(R.id.editFirstName))
                    .perform(replaceText("Mikal"));
            onView(withId(R.id.editLastName))
                    .perform(replaceText("Viencek"));
            closeSoftKeyboard();
            onView(withId(R.id.year)).perform(click());
            onData(allOf(is(instanceOf(Integer.class)))).atPosition(1).perform(click());
            onView(withId(R.id.month)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
            onView(withId(R.id.day)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
            onView(withId(R.id.relationship)).perform(click());
            onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
            onView(withId(R.id.editPosition))
                    .perform(replaceText("Technical Support Specialist"));
            closeSoftKeyboard();
            onView(withId(R.id.editGroup))
                    .perform(replaceText("North Seattle"));
            closeSoftKeyboard();
            onView(withId(R.id.editInterests))
                    .perform(replaceText("Video Games"));
            closeSoftKeyboard();
            onView(withText("Save Changes"))
                    .perform(scrollTo(), click());
            Thread.sleep(10000);
            onView(withId(R.id.profileName))
                    .check(matches(withText("Mikal Viencek")));
            onView(withId(R.id.profileGroup))
                    .check(matches(withText("North Seattle")));
            onView(withId(R.id.profileInterest))
                    .check(matches(withText("Video Games")));
            onView(withId(R.id.profilePosition))
                    .check(matches(withText("Technical Support Specialist")));
            onView(withId(R.id.profileRelationshipText))
                    .check(matches(withText("Married")));
        }
    }

    @Test
    public void testProfileDrawer() throws Exception {
        Thread.sleep(5000);
        onView(withId(R.id.main_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_sign_out));
        Thread.sleep(5000);
        onView(withId(R.id.lblogin_main)).perform(clickClickableSpan("Sign In"));
        onView(withId(R.id.email_login)).perform(typeText("clint@clintshawvideo.com")).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password_login)).perform(typeText("test123")).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(8000);
        onView(withId(R.id.main_content)).check(matches(isDisplayed()));
        onView(withId(R.id.main_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
        Thread.sleep(5000);
        onView(withId(R.id.profile_content)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_profile)).perform(NavigationViewActions.navigateTo(R.id.nav_discounts));
        Thread.sleep(5000);
        onView(withId(R.id.discounts_content)).check(matches(isDisplayed()));
        onView(withId(R.id.discounts_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_discount)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
        Thread.sleep(5000);
        onView(withId(R.id.profile_content)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_profile)).perform(NavigationViewActions.navigateTo(R.id.nav_buddies));
        Thread.sleep(5000);
        onView(withId(R.id.buddies_content)).check(matches(isDisplayed()));
        onView(withId(R.id.buddies_content)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_buddies)).perform(NavigationViewActions.navigateTo(R.id.nav_profile));
        Thread.sleep(5000);
//        onView(withId(R.id.profile_content)).check(matches(isDisplayed()));
//        onView(withId(R.id.profile_content)).perform(DrawerActions.open());
//        onView(withId(R.id.nav_view_profile)).perform(NavigationViewActions.navigateTo(R.id.nav_messaging));
    }

    //static method for clicking on clickable spans in textviews
    public static ViewAction clickClickableSpan(final CharSequence textToClick) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return Matchers.instanceOf(TextView.class);
            }

            @Override
            public String getDescription() {
                return "clicking on a ClickableSpan";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView textView = (TextView) view;
                SpannableString spannableString = (SpannableString) textView.getText();

                if (spannableString.length() == 0) {
                    // TextView is empty, nothing to do
                    throw new NoMatchingViewException.Builder()
                            .includeViewHierarchy(true)
                            .withRootView(textView)
                            .build();
                }

                // Get the links inside the TextView and check if we find textToClick
                ClickableSpan[] spans = spannableString.getSpans(0, spannableString.length(), ClickableSpan.class);
                if (spans.length > 0) {
                    ClickableSpan spanCandidate;
                    for (ClickableSpan span : spans) {
                        spanCandidate = span;
                        int start = spannableString.getSpanStart(spanCandidate);
                        int end = spannableString.getSpanEnd(spanCandidate);
                        CharSequence sequence = spannableString.subSequence(start, end);
                        if (textToClick.toString().equals(sequence.toString())) {
                            span.onClick(textView);
                            return;
                        }
                    }
                }

                // textToClick not found in TextView
                throw new NoMatchingViewException.Builder()
                        .includeViewHierarchy(true)
                        .withRootView(textView)
                        .build();

            }
        };
    }
}


