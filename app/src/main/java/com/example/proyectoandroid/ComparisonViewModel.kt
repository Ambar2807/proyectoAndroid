package com.example.proyectoandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComparisonViewModel : ViewModel() {
    private val resultLiveData = MutableLiveData<String>()

    fun getResultLiveData(): LiveData<String> = resultLiveData

    fun compareStrings(text1: String, text2: String) {
        val result = if (text1 == text2) {
            "Las cadenas son iguales."
        } else {
            "Las cadenas son diferentes."
        }
        resultLiveData.value = result
    }
}
