package com.sevenpeakssoftware.mihira.ui.cars


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sevenpeakssoftware.mihira.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CarsActivityUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(CarsActivity::class.java)

    @Test
    fun carsActivityUITest() {
        val progressBar = onView(
            allOf(
                withId(R.id.progress),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        progressBar.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.tv_title_top), withText("Cars"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_title),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.tv_title_top), withText("Cars"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_title),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Cars")))

        val button = onView(
            allOf(
                withId(R.id.snackbar_action),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.snackbar_text), withText("An error occurred while loading the cars"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.snackbar_text), withText("An error occurred while loading the cars"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(isDisplayed()))

        val textView5 = onView(
            allOf(
                withId(R.id.snackbar_text), withText("An error occurred while loading the cars"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("An error occurred while loading the cars")))

        val linearLayout = onView(
            allOf(
                withId(R.id.action_bar_root),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        linearLayout.check(matches(isDisplayed()))

        val viewGroup = onView(
            allOf(
                withId(R.id.srl_cars),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        val recyclerView = onView(
            allOf(
                withId(R.id.rv_cars),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.srl_cars),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.tv_datetime), withText("25 May 2018, 19:43"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.rl_gallery_item),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(isDisplayed()))

        val textView7 = onView(
            allOf(
                withId(R.id.tv_description),
                withText("The Audi Q7 is the result of an ambitious idea: never cease to improve."),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.rl_gallery_item),
                        3
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView7.check(matches(isDisplayed()))

        val imageView = onView(
            allOf(
                withId(R.id.iv_gallery_item),
                childAtPosition(
                    allOf(
                        withId(R.id.rl_gallery_item),
                        childAtPosition(
                            withId(R.id.rv_cars),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView8 = onView(
            allOf(
                withId(R.id.tv_title), withText("Q5 - Created for almost any landscape."),
                childAtPosition(
                    allOf(
                        withId(R.id.rl_gallery_item),
                        childAtPosition(
                            withId(R.id.rv_cars),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("Q5 - Created for almost any landscape.")))

        val textView9 = onView(
            allOf(
                withId(R.id.tv_title), withText("Q5 - Created for almost any landscape."),
                childAtPosition(
                    allOf(
                        withId(R.id.rl_gallery_item),
                        childAtPosition(
                            withId(R.id.rv_cars),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView9.check(matches(isDisplayed()))

        val textView10 = onView(
            allOf(
                withId(R.id.tv_datetime), withText("29 November 2017, 20:42"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.rl_gallery_item),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView10.check(matches(withText("29 November 2017, 20:42")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
