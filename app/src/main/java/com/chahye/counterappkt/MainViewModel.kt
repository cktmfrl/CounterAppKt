package com.chahye.counterappkt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var count = 0

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount() {
        count++
        countLiveData.value = count
    }

    fun decreaseCount() {
        count++
        countLiveData.value = count
    }
}