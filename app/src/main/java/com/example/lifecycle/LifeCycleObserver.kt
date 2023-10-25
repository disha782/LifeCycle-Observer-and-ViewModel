package com.example.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ProcessLifecycleOwner

//lifecycle aware components
class LifeCycleObserver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleEventObserver)
    }

    var lifecycleEventObserver = LifecycleEventObserver{_, event ->
        when(event){
            Lifecycle.Event.ON_CREATE -> {
                Log.d("TAG", "OBSERVER ONCREATE")
            }
            Lifecycle.Event.ON_START -> {
                Log.d("TAG", "OBSERVER ON_START")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d("TAG", "OBSERVER ON_PAUSE")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d("TAG", "OBSERVER ON_RESUME")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d("TAG", "OBSERVER ON_STOP")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d("TAG", "OBSERVER ON_DESTROY")
            }
            else -> {}
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "ON_START")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy")
    }
}