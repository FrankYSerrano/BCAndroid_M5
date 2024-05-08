package com.example

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.AppConstant.Companion.LOG_MAIN_ACTIVITY
import com.example.programandokotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    override fun onStart() {
        super.onStart()
        logger("onStart()")
    }
    override fun onResume() {
        super.onResume()
        logger("onResume()")
    }
    override fun onPause() {
        super.onPause()
        logger("onPause()")
    }
    override fun onStop() {
        super.onStop()
        logger("onStop()")
    }
    override fun onRestart() {
        super.onRestart()
        logger("onRestart()")
    }
    override fun onDestroy() {
        super.onDestroy()
        logger("onDestroy()")
    }



    fun logger (mensaje: String){
        Log.i(LOG_MAIN_ACTIVITY, mensaje)
    }
}