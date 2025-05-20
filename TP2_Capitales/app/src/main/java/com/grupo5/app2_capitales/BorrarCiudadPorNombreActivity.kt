package com.grupo5.app2_capitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.grupo5.app2_capitales.data.AppDatabase
import kotlinx.coroutines.launch
import android.view.View

class BorrarCiudadPorNombreActivity : AppCompatActivity() {

    private lateinit var etCiudadABorrar: EditText
    private lateinit var btnBorrarCiudad: Button
    private lateinit var tvResultadoBorrado: TextView
    private lateinit var ivBack: ImageView
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrar_ciudad)

        etCiudadABorrar = findViewById(R.id.etCiudadABorrar)
        btnBorrarCiudad = findViewById(R.id.btnBorrarCiudad)
        tvResultadoBorrado = findViewById(R.id.tvResultadoBorrado)
        ivBack = findViewById(R.id.ivBack)
        db = AppDatabase.getDatabase(this)

        ivBack.setOnClickListener {
            finish()
        }

        btnBorrarCiudad.setOnClickListener {
            val nombreCiudad = etCiudadABorrar.text.toString().trim()

            if (nombreCiudad.isNotEmpty()) {
                lifecycleScope.launch {
                    val ciudad = db.ciudadDao().obtenerPorNombre(nombreCiudad)
                    if (ciudad != null) {
                        db.ciudadDao().borrarPorNombre(ciudad.nombreCiudad)
                        mostrarResultado("Ciudad ${ciudad.nombreCiudad} eliminada correctamente.")
                    } else {
                        mostrarResultado("La ciudad no existe.")
                    }
                }
            } else {
                mostrarResultado("Ingresá el nombre de la ciudad.")
            }
        }
    }

    private fun mostrarResultado(mensaje: String) {
        tvResultadoBorrado.text = mensaje
        tvResultadoBorrado.visibility = View.VISIBLE
    }
}
