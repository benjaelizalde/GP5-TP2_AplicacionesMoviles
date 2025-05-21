package com.grupo5.app2_random

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var btnVolverJugar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        tvResultado = findViewById(R.id.tvResultado)
        btnVolverJugar = findViewById(R.id.btnVolverJugar)

        val score = intent.getIntExtra("score", 0)
        val highScore = intent.getIntExtra("highScore", 0)
        val nuevoHighScore = intent.getBooleanExtra("nuevoHighScore", false)

        val mensaje = buildString {
            append("Tu puntaje fue: $score\n")
            append("Tu récord actual es: $highScore\n")
            if (nuevoHighScore) {
                append("🎉 ¡Felicitaciones! ¡Nuevo récord logrado!")
            }
        }

        tvResultado.text = mensaje

        btnVolverJugar.setOnClickListener {
            btnVolverJugar.animarVista()
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
