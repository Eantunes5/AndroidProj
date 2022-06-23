package com.example.appfinanca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        //Pega o texto de qtd
        var qtd = findViewById<EditText>(R.id.valorGasto)
        recyclerView = findViewById(R.id.recyclerViewGasto)
        gastoAdapter = GastoAdapter(clickListener =
        object : OnClickedListener{
            override fun onItemClicked(view: View, position: Int) {
                val gasto = GastoModel.instance.gastos[position]
                gasto.valor = "1000"
                GastoModel.instance.updateGasto(gasto)
                gastoAdapter.notifyItemChanged(position)
            }

            override fun onItemLongClicked(view: View, position: Int) {
                GastoModel.instance.removeGasto(
                    GastoModel.instance.gastos[position]
                )
                gastoAdapter.notifyItemRemoved(position)
            }

        })


        recyclerView.adapter = gastoAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this)
        findViewById<Button>(R.id.buttonInsiraGasto).setOnClickListener {
            GastoModel.instance.addGasto(
                //Coloca o texto no botão
                GastoEntity(valor=qtd.text.toString())
            )
            gastoAdapter.notifyItemInserted(
                GastoModel.instance.gastos.size - 1
            )
        }
    }

}