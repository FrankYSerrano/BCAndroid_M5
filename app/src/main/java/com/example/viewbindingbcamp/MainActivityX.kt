package com.example.viewbindingbcamp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.programandokotlin.R
import com.example.programandokotlin.databinding.ActivityMainBinding

class MainActivityX : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.textViewTitle.setText(R.string.app_name)
  //      binding.buttonPulsame.setOnClickListener{toastApp()}
    }

    private fun toastApp(){
        Toast.makeText(this, "ME PULSARON", Toast.LENGTH_SHORT).show()
    }

}