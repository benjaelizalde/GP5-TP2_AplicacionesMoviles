package com.grupo5.app2_random

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone


class RulesActivity : AppCompatActivity() {

    private lateinit var tvRegla1: TextView
    private lateinit var tvContenidoRegla1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        tvRegla1 = findViewById(R.id.tvRegla1)
        tvContenidoRegla1 = findViewById(R.id.tvContenidoRegla1)

        tvRegla1.setOnClickListener {
            if (tvContenidoRegla1.isGone) {
                tvContenidoRegla1.isGone = false
            } else {
                tvContenidoRegla1.isGone = true
            }

        }
    }
}
