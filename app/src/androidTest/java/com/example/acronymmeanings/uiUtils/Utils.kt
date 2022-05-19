package com.example.acronymmeanings.uiUtils

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.acronymmeanings.search.SearchAdapter


fun typeTextWithId(id: Int, textToBeTyped: String) {
    onView(withId(id))
        .perform(typeText(textToBeTyped))
}

fun scrollAtAndCheckTestVisible(id: Int, position: Int, text: String) {
    onView(withId(id))
        .perform(
            RecyclerViewActions
                .scrollToPosition<SearchAdapter.TextItemViewHolder>(position)
        )
    onView(withText(text)).check(matches(isDisplayed()))
}

