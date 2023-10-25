package com.example.lifecycle

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(){
    lateinit var txtCounter : TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModelProvider => 2 parameters lifecycle owner and whose class you want
        //mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //ViewModel Factory. To create MainViewModel with parameter
        mainViewModel = ViewModelProvider(this, ViewModelFactory(10))[MainViewModel::class.java]
        txtCounter = findViewById(R.id.count)
        setText()
    }

    private fun setText() {
        txtCounter.text = mainViewModel.count.toString()
    }

    fun increment(v: View){
        mainViewModel.increment()
        setText()
    }

}