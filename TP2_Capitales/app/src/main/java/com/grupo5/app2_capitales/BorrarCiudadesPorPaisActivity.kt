package com.grupo5.app2_capitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.grupo5.app2_capitales.data.AppDatabase
import kotlinx.coroutines.launch
import android.view.View

class BorrarCiudadesPorPaisActivity : AppCompatActivity() {

    private lateinit var etPaisABorrar: EditText
    private lateinit var btnBorrarCiudades: Button
    private lateinit var tvResultadoBorrado: TextView
    private lateinit var ivBack: ImageView
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrar_ciudades_por_pais)

        etPaisABorrar = findViewById(R.id.etPaisABorrar)
        btnBorrarCiudades = findViewById(R.id.btnBorrarCiudades)
        tvResultadoBorrado = findViewById(R.id.tvResultadoBorrado)
        ivBack = findViewById(R.id.ivBack)
        db = AppDatabase.getDatabase(this)

        ivBack.setOnClickListener {
            finish()
        }

        btnBorrarCiudades.setOnClickListener {
            btnBorrarCiudades.animarVista()
            val pais = etPaisABorrar.text.toString().trim()

            if (pais.isNotEmpty()) {
                lifecycleScope.launch {
                    db.ciudadDao().borrarPorPais(pais)
                    mostrarResultado("Ciudades de $pais eliminadas correctamente.")
                }
            } else {
                mostrarResultado("Ingresá el nombre del país.")
            }
        }
    }

    private fun mostrarResultado(mensaje: String) {
        tvResultadoBorrado.text = mensaje
        tvResultadoBorrado.visibility = View.VISIBLE
    }
}
