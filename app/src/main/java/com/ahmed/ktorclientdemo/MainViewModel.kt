package com.ahmed.ktorclientdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var loading = MutableLiveData(false)

    var response: MutableLiveData<List<PersonEntity>?> = MutableLiveData()

    private val apiService by lazy {
        ApiService.create()
    }

    fun fetchResult() {
        viewModelScope.launch(Dispatchers.IO) {
            loading.value = true
            val networkResponse = apiService.getProducts()
            if (networkResponse.size != 0) {
                response.value = networkResponse
                loading.value = false
            } else {
                response.value = null
                loading.value = false
            }
        }
    }

}