package com.grupo5.app2_random

import android.view.View

fun View.animarVista() {
    this.animate()
        .scaleX(1.1f)
        .scaleY(1.1f)
        .setDuration(100)
        .withEndAction {
            this.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(100)
                .start()
        }
        .start()
}

fun View.animarMostrar() {
    this.visibility = View.VISIBLE
    this.scaleX = 0f
    this.scaleY = 0f
    this.animate()
        .scaleX(1f)
        .scaleY(1f)
        .setDuration(300)
        .start()
}

fun View.animarOcultar(despuesOcultar: Boolean = true) {
    this.animate()
        .scaleX(0f)
        .scaleY(0f)
        .setDuration(300)
        .withEndAction {
            if (despuesOcultar) {
                this.visibility = View.GONE
            }
        }
        .start()
}
