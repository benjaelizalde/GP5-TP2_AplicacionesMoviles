package com.grupo5.app2_capitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.grupo5.app2_capitales.data.AppDatabase
import com.grupo5.app2_capitales.data.Ciudad
import kotlinx.coroutines.launch
import android.view.View

class CargarCiudadActivity : AppCompatActivity() {

    private lateinit var etNombrePais: EditText
    private lateinit var etNombreCiudad: EditText
    private lateinit var etPoblacion: EditText
    private lateinit var btnAgregar: Button
    private lateinit var tvResultado: TextView
    private lateinit var ivBack: ImageView

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargar_ciudad)

        etNombrePais = findViewById(R.id.etNombrePais)
        etNombreCiudad = findViewById(R.id.etNombreCiudad)
        etPoblacion = findViewById(R.id.etPoblacion)
        btnAgregar = findViewById(R.id.btnAgregar)
        tvResultado = findViewById(R.id.tvResultado)
        ivBack = findViewById(R.id.ivBack)

        db = AppDatabase.getDatabase(this)

        ivBack.setOnClickListener {
            finish()
        }
        btnAgregar.setOnClickListener {
            btnAgregar.animarVista()
            val nombrePais = etNombrePais.text.toString().trim()
            val nombreCiudad = etNombreCiudad.text.toString().trim()
            val poblacion = etPoblacion.text.toString().trim().toIntOrNull()

            if (nombrePais.isNotEmpty() && nombreCiudad.isNotEmpty() && poblacion != null) {
                val ciudad = Ciudad(nombreCiudad, nombrePais, poblacion)

                lifecycleScope.launch {
                    db.ciudadDao().insertar(ciudad)
                    mostrarResultado("Ciudad ${ciudad.nombreCiudad} agregada exitosamente!")
                }
            } else {
                mostrarResultado("Por favor ingresá todos los campos correctamente.")
            }
        }
    }

    private fun mostrarResultado(mensaje: String) {
        tvResultado.text = mensaje
        tvResultado.visibility = View.VISIBLE
    }
}
