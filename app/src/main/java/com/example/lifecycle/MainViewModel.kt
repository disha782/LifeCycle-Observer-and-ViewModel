package com.example.lifecycle

import androidx.lifecycle.ViewModel

class MainViewModel(val initial : Int) : ViewModel() {
    var count : Int = initial

    fun increment(){
        count++
    }
}