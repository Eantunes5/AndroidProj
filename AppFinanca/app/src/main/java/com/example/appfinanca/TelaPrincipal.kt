package com.example.appfinanca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
    }

    fun btnTelaSaldo(view: View){
        val intent = Intent(this, Saldo::class.java)
        startActivity(intent)
    }
    fun btnTelaGanho(view: View){
        val intent = Intent(this, Ganho::class.java)
        startActivity(intent)
    }
    fun btnTelaGasto(view: View){
        val intent = Intent(this, Gasto::class.java)
        startActivity(intent)
    }
}