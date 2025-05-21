package com.grupo5.app2_capitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnCargar: Button
    private lateinit var btnConsultar : Button
    private lateinit var btnBorrarCiudad : Button
    private lateinit var btnBorrarPais : Button
    private lateinit var btnModificarPoblacion : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCargar=findViewById(R.id.btnCargar)
        btnConsultar=findViewById(R.id.btnConsultar)
        btnBorrarCiudad=findViewById(R.id.btnBorrarCiudad)
        btnBorrarPais=findViewById(R.id.btnBorrarPais)
        btnModificarPoblacion=findViewById(R.id.btnModificarPoblacion)

        btnCargar.setOnClickListener {
            btnCargar.animarVista()
            startActivity(Intent(this, CargarCiudadActivity::class.java))
        }

        btnConsultar.setOnClickListener {
            btnConsultar.animarVista()
            startActivity(Intent(this, ConsultarCiudadActivity::class.java))
        }

        btnBorrarCiudad.setOnClickListener {
            btnBorrarCiudad.animarVista()
            startActivity(Intent(this, BorrarCiudadPorNombreActivity::class.java))
        }

        btnBorrarPais.setOnClickListener {
            btnBorrarPais.animarVista()
            startActivity(Intent(this, BorrarCiudadesPorPaisActivity::class.java))
        }

        btnModificarPoblacion.setOnClickListener {
            btnModificarPoblacion.animarVista()
            startActivity(Intent(this, ModificarPoblacionActivity::class.java))
        }
    }
}
