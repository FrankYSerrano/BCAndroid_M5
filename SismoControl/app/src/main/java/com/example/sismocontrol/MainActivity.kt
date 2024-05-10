package com.example.sismocontrol

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sismocontrol.adapters.SismoAdapter
import com.example.sismocontrol.databinding.ActivityMainBinding
import com.example.sismocontrol.entities.Sismo
import java.net.URLEncoder

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

        sismoAdaptador.onItemClickListener = {
            Toast.makeText(this, it.lugar, Toast.LENGTH_SHORT).show()
            enviarCorreoElectronicoSismo(it)
        }

//        sismoAdaptador.sismos = Sismo.dataEmpty
        if (sismoAdaptador.sismos.isEmpty())
            binding.empty.visibility = View.VISIBLE
        else
            binding.empty.visibility = View.GONE
    }

    //OJO PREGUNTA DE EXAMEN: Implementacion de Intent Implicito
    private fun enviarCorreoElectronicoSismo(it: Sismo) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("urbnt01@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "ALERTA: Envio de Sismo!")
        intent.putExtra(Intent.EXTRA_TEXT, "Hola Agustin! Temblo en ${it.lugar} de magnitud ${it.magnitud} ")
        if (intent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(intent, "Enviar sismo x correo"))
        } else
            Toast.makeText(this, "Instalar app de email", Toast.LENGTH_LONG).show()
    }

    private fun enviarMensajeWhatsapp(sismo: Sismo){

        val telefonoWsp = "+56952593215"
        val mensaje = "TERREMOTO en ${sismo.lugar}"
        val uri = Uri.parse("https://api.whatsapp.com/send?" +
                "phone=$telefonoWsp&" +
                "text=${URLEncoder.encode(mensaje,"UTF-8")}")
        var intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(intent, "Enviar sismo x correo"))
        } else
            Toast.makeText(this, "Instalar app de emai", Toast.LENGTH_LONG).show()





    }
}