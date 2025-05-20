package com.grupo5.app2_capitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.grupo5.app2_capitales.data.AppDatabase
import kotlinx.coroutines.launch
import android.view.View

class ConsultarCiudadActivity : AppCompatActivity() {

    private lateinit var etNombreCiudad: EditText
    private lateinit var btnBuscar: Button
    private lateinit var tvResultado: TextView
    private lateinit var ivBack: ImageView

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_ciudad)

        etNombreCiudad = findViewById(R.id.etNombreCiudad)
        btnBuscar = findViewById(R.id.btnBuscar)
        tvResultado = findViewById(R.id.tvResultado)
        ivBack = findViewById(R.id.ivBack)

        db = AppDatabase.getDatabase(this)

        ivBack.setOnClickListener {
            finish()
        }

        btnBuscar.setOnClickListener {
            val nombreCiudad = etNombreCiudad.text.toString().trim()

            if (nombreCiudad.isNotEmpty()) {
                lifecycleScope.launch {
                    val ciudad = db.ciudadDao().obtenerPorNombre(nombreCiudad)

                    if (ciudad != null) {
                        val resultado = """
                            Ciudad: ${ciudad.nombreCiudad}
                            País: ${ciudad.nombrePais}
                            Población: ${ciudad.poblacion}
                        """.trimIndent()
                        tvResultado.text = resultado
                    } else {
                        tvResultado.text = "No se encontró ninguna ciudad con ese nombre."
                    }
                }
            } else {
                tvResultado.text = "Ingresá el nombre de una ciudad."
            }
            tvResultado.visibility = View.VISIBLE

        }
    }
}
