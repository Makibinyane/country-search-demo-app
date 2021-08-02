package com.example.country_search_demo_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.country_search_demo_app.repo.SearchCountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCountryViewModel @Inject constructor(private val repository: SearchCountryRepository) :
    ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    val countryData = repository.data

    fun getCountryDetailsByName(countryName: String) {
        viewModelScope.launch {
            try {
                loading.value = true
                repository.getCountryDetailsByName(countryName)
                loading.value = false
            } catch (ex: Exception) {
                ex.message?.let { onError(it) }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

}