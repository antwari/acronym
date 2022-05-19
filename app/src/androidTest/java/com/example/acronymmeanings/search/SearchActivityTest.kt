package com.example.acronymmeanings.search

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.acronymmeanings.R
import com.example.acronymmeanings.uiUtils.scrollAtAndCheckTestVisible
import com.example.acronymmeanings.uiUtils.typeTextWithId
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class SearchActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(SearchActivity::class.java)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun check_if_the_search_edit_text_is_displayed() {
        onView(withId(R.id.search_et)).check(matches(isDisplayed()))
    }

    @Test
    fun check_if_recycle_view_contains_fake_data() {
        val acronym = "NASA"
        typeTextWithId(R.id.search_et,acronym)
        scrollAtAndCheckTestVisible(R.id.meaning_list,0,"National Aeronautics and Space Administration")
    }




}
