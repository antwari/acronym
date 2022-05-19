package com.example.acronymmeanings.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronymmeanings.Utils.Resource
import com.example.acronymmeanings.repo.Search
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.acronymmeanings.models.Meaning
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: Search) : ViewModel() {
    /**
     * hold meanings liveData list that can be accessed outside of the viewModel
     */
    val meanings: LiveData<Resource<List<Meaning>>>
        get() = _meanings

    private val _meanings = MutableLiveData<Resource<List<Meaning>>>()

    /**
     * This function fetch data from the API
     * @param acronym , String that we are looking for
     * @return no return
     */
    fun fetch(acronym: String) {

        if (acronym.isEmpty()) {
            return
        }

        _meanings.value = Resource.loading(null)
        viewModelScope.launch {
            try {
                _meanings.value = repository.fetchMeanings(acronym)
            } catch (e: Exception) {

            }
        }
    }
}

