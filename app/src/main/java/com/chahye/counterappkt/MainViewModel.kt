package com.chahye.counterappkt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * SavedStateHandle : 시스템에 의한 종료 시 UI 상태 유지
 */
class MainViewModel(private val handle: SavedStateHandle) : ViewModel() {
    private var count = handle.get<Int>("count") ?: 0
        set(value) {
            field = value
            countLiveData.value = value
            handle["count"] = value
        }

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }
}