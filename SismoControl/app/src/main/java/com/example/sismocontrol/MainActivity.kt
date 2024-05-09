package com.example.sismocontrol

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sismocontrol.adapters.SismoAdapter
import com.example.sismocontrol.databinding.ActivityMainBinding
import com.example.sismocontrol.entities.Sismo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerSismos.layoutManager = LinearLayoutManager(this)
        initAdapter()




    }

    private fun initAdapter(){
        val sismoAdaptador = SismoAdapter()
        binding.recyclerSismos.adapter = sismoAdaptador
        sismoAdaptador.sismos = Sismo.dataSismos
    }
}