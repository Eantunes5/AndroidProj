package com.example.appfinanca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinanca.adapter.GanhoAdapter
import com.example.appfinanca.adapter.GastoAdapter
import com.example.appfinanca.entity.GanhoEntity
import com.example.appfinanca.model.GanhoModel
import com.example.appfinanca.db.DbFinance
import com.example.appfinanca.entity.GastoEntity
import com.example.appfinanca.model.GastoModel
//Classe gasto é a mesma coisa
class Ganho : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var ganhoAdapter: GanhoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganho)
        GanhoModel.instance.setContext(this)
        //Coloca o recyclerView como sendo o recyclerVIew que está la na pagina do ganho
        recyclerView = findViewById(R.id.recyclerViewGanho)

        //Aqui pelo que eu entendi, coloca a função no botão para adicionar um ganho e depois inserir no recyclerView
        recyclerView.adapter = ganhoAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this)
        findViewById<Button>(R.id.buttonInsiraGanho).setOnClickListener {
            GanhoModel.instance.addGanho(
                GanhoEntity(valor="11000")
            )
            ganhoAdapter.notifyItemInserted(
                GanhoModel.instance.ganhos.size - 1
            )
        }
    }

}