package com.grupo5.app2_random

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone


class RulesActivity : AppCompatActivity() {

    private lateinit var tvRegla1: TextView
    private lateinit var tvContenidoRegla1: TextView
    private lateinit var tvRegla2: TextView
    private lateinit var tvContenidoRegla2: TextView
    private lateinit var tvRegla3: TextView
    private lateinit var tvContenidoRegla3: TextView
    private lateinit var tvRegla4: TextView
    private lateinit var tvContenidoRegla4: TextView
    private lateinit var tvRegla5: TextView
    private lateinit var tvContenidoRegla5: TextView
    private lateinit var btnVolverAlJuego: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        tvRegla1 = findViewById(R.id.tvRegla1)
        tvContenidoRegla1 = findViewById(R.id.tvContenidoRegla1)
        tvRegla2 = findViewById(R.id.tvRegla2)
        tvContenidoRegla2 = findViewById(R.id.tvContenidoRegla2)
        tvRegla3 = findViewById(R.id.tvRegla3)
        tvContenidoRegla3 = findViewById(R.id.tvContenidoRegla3)
        tvRegla4 = findViewById(R.id.tvRegla4)
        tvContenidoRegla4 = findViewById(R.id.tvContenidoRegla4)
        tvRegla5 = findViewById(R.id.tvRegla5)
        tvContenidoRegla5 = findViewById(R.id.tvContenidoRegla5)


        tvRegla1.setOnClickListener {
            if (tvContenidoRegla1.isGone) {
                tvContenidoRegla1.isGone = false
            } else {
                tvContenidoRegla1.isGone = true
            }
        }
        tvRegla2.setOnClickListener {
            if (tvContenidoRegla2.isGone) {
                tvContenidoRegla2.isGone = false
            } else {
                tvContenidoRegla2.isGone = true
            }
        }
        tvRegla3.setOnClickListener {
            if (tvContenidoRegla3.isGone) {
                tvContenidoRegla3.isGone = false
            } else {
                tvContenidoRegla3.isGone = true
            }
        }
        tvRegla4.setOnClickListener {
            if (tvContenidoRegla4.isGone) {
                tvContenidoRegla4.isGone = false
            } else {
                tvContenidoRegla4.isGone = true
            }
        }
        tvRegla5.setOnClickListener {
            if (tvContenidoRegla5.isGone) {
                tvContenidoRegla5.isGone = false
            } else {
                tvContenidoRegla5.isGone = true
            }
        }

        btnVolverAlJuego = findViewById(R.id.btnVolverAlJuego)
        btnVolverAlJuego.setOnClickListener {
            btnVolverAlJuego.animarVista()
            finish()
        }

    }
}
