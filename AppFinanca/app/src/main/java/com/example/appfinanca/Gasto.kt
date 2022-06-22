package com.example.appfinanca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinanca.adapter.GastoAdapter
import com.example.appfinanca.entity.GastoEntity
import com.example.appfinanca.model.GastoModel

class Gasto : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var gastoAdapter: GastoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gasto)
        GastoModel.instance.setContext(this)
        recyclerView = findViewById(R.id.recyclerViewGasto)

        recyclerView.adapter = gastoAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this)
        findViewById<Button>(R.id.buttonInsiraGasto).setOnClickListener {
            GastoModel.instance.addGasto(
                GastoEntity(valor="8000")
            )
            gastoAdapter.notifyItemInserted(
                GastoModel.instance.gastos.size - 1
            )
        }
    }

}