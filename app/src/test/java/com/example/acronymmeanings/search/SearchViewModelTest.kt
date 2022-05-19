package com.example.acronymmeanings.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.acronymmeanings.Utils.Status
import com.example.acronymmeanings.repo.FakeSearchRepo
import com.example.acronymmeanings.utils.MainCoroutineRule
import com.example.acronymmeanings.utils.getOrAwaitValueTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setup() {
        viewModel = SearchViewModel(FakeSearchRepo())
    }

    @Test
    fun `check if the fetch viewModel method assigns the data to the meanings liveData`() {
        viewModel.fetch("NASA")
        val value = viewModel.meanings.getOrAwaitValueTest()
        assertThat("Livedata from the viewModel ", value.status, `is`(Status.SUCCESS))
    }

}