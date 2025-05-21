package com.grupo5.app2_capitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.grupo5.app2_capitales.data.AppDatabase
import kotlinx.coroutines.launch
import android.view.View

class ModificarPoblacionActivity : AppCompatActivity() {

    private lateinit var etCiudadAModificar: EditText
    private lateinit var etNuevaPoblacion: EditText
    private lateinit var btnModificarPoblacion: Button
    private lateinit var tvResultadoModificacion: TextView
    private lateinit var ivBack: ImageView
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_poblacion)

        etCiudadAModificar = findViewById(R.id.etCiudadAModificar)
        etNuevaPoblacion = findViewById(R.id.etNuevaPoblacion)
        btnModificarPoblacion = findViewById(R.id.btnModificarPoblacion)
        tvResultadoModificacion = findViewById(R.id.tvResultadoModificacion)
        ivBack = findViewById(R.id.ivBack)
        db = AppDatabase.getDatabase(this)

        ivBack.setOnClickListener {
            finish()
        }


        btnModificarPoblacion.setOnClickListener {
            btnModificarPoblacion.animarVista()
            val nombreCiudad = etCiudadAModificar.text.toString().trim()
            val nuevaPoblacion = etNuevaPoblacion.text.toString().trim().toIntOrNull()

            if (nombreCiudad.isNotEmpty() && nuevaPoblacion != null) {
                lifecycleScope.launch {
                    val ciudad = db.ciudadDao().obtenerPorNombre(nombreCiudad)
                    if (ciudad != null) {
                        db.ciudadDao().actualizarPoblacion(nombreCiudad, nuevaPoblacion)
                        mostrarResultado("Población de $nombreCiudad modificada correctamente.")
                    } else {
                        mostrarResultado("No se encontró ninguna ciudad con ese nombre.")
                    }
                }
            } else {
                mostrarResultado("Ingresá el nombre de la ciudad y la nueva población.")
            }
        }
    }

    private fun mostrarResultado(mensaje: String) {
        tvResultadoModificacion.text = mensaje
        tvResultadoModificacion.visibility = View.VISIBLE
    }
}
