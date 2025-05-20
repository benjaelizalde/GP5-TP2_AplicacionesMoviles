package com.grupo5.app2_random

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNumero: EditText
    private lateinit var btnAdivinar: Button
    private lateinit var tvMensaje: TextView
    private lateinit var tvPuntaje: TextView
    private lateinit var tvRecord: TextView
    private lateinit var btnVerReglas: Button

    private var numeroSecreto = 0
    private var score = 0
    private var highScore = 0
    private var intentosErrados = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumero = findViewById(R.id.etNumero)
        btnAdivinar = findViewById(R.id.btnAdivinar)
        tvMensaje = findViewById(R.id.tvMensaje)
        tvPuntaje = findViewById(R.id.tvPuntaje)
        tvRecord = findViewById(R.id.tvRecord)
        btnVerReglas = findViewById(R.id.btnVerReglas)

        val prefs = getSharedPreferences("juego", MODE_PRIVATE)
        highScore = prefs.getInt("highScore", 0)

        tvRecord.text = "Mejor puntaje: $highScore"
        tvPuntaje.text = "Puntaje actual: $score"

        //numeroSecreto = (1..5).random()
        numeroSecreto = 3

        btnAdivinar.setOnClickListener {
            val numeroIngresado = etNumero.text.toString().toIntOrNull()
            if (numeroIngresado == null || numeroIngresado !in 1..5) {
                tvMensaje.text = "Por favor ingresá un número del 1 al 5"
                return@setOnClickListener
            }

            if (numeroIngresado == numeroSecreto) {
                score += 10
                tvMensaje.text = "¡Correcto! Número nuevo..."
                //numeroSecreto = (1..5).random()
                numeroSecreto = 3
                intentosErrados = 0
            } else {
                intentosErrados++
                tvMensaje.text = "Fallaste. Intento $intentosErrados de 5"
            }

            tvPuntaje.text = "Puntaje actual: $score"

            if (score > highScore) {
                highScore = score
                prefs.edit().putInt("highScore", highScore).apply()
                tvRecord.text = "🎉 Nuevo récord: $highScore"
            }

            if (intentosErrados >= 5) {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("highScore", highScore)
                intent.putExtra("nuevoHighScore", score >= highScore)
                startActivity(intent)
            }

            etNumero.text.clear()

            btnVerReglas.setOnClickListener {
                val intent = Intent(this, RulesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
