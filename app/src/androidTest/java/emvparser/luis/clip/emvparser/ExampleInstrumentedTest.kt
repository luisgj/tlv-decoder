package emvparser.luis.clip.emvparser

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import emvparser.luis.clip.emvparser.common.Constants

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    public val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("emvparser.luis.clip.emvparser", appContext.packageName)
    }

    @Test
    fun clicksExample1() {
        onView(withId(R.id.example_1))
                .perform(click())
        onView(withId(R.id.tlv_list))
                .check(matches(isDisplayed()))
    }

    @Test
    fun clicksExample2() {
        onView(withId(R.id.example_2))
                .perform(click())
        onView(withId(R.id.tlv_list))
                .check(matches(isDisplayed()))
    }

    @Test
    fun showsInvalidAlert() {
        onView(withId(R.id.input_tlv))
                .perform(typeText("Invalid Hex code"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.whatever))
                .perform(click())
        onView(withText("The value cant be translated to any valid EMV transaction"))
                .check(matches(isDisplayed()))
    }

    @Test
    fun decodesFromInput() {
        onView(withId(R.id.input_tlv))
                .perform(typeText(Constants.CHIPCARD1), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.whatever))
                .perform(click())
        onView(withId(R.id.tlv_list))
                .check(matches(isDisplayed()))
    }
}
