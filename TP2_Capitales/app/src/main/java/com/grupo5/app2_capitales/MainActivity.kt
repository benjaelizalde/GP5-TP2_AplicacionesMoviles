package com.grupo5.app2_capitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnCargar).setOnClickListener {
            startActivity(Intent(this, CargarCiudadActivity::class.java))
        }

        findViewById<Button>(R.id.btnConsultar).setOnClickListener {
            startActivity(Intent(this, ConsultarCiudadActivity::class.java))
        }

        findViewById<Button>(R.id.btnBorrarCiudad).setOnClickListener {
            startActivity(Intent(this, BorrarCiudadPorNombreActivity::class.java))
        }

        findViewById<Button>(R.id.btnBorrarPais).setOnClickListener {
            startActivity(Intent(this, BorrarCiudadesPorPaisActivity::class.java))
        }

        findViewById<Button>(R.id.btnModificarPoblacion).setOnClickListener {
            startActivity(Intent(this, ModificarPoblacionActivity::class.java))
        }
    }
}
