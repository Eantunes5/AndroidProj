package com.example.appfinanca.model

import android.content.Context
import com.example.appfinanca.db.DbFinance
import com.example.appfinanca.entity.GastoEntity

class GastoModel private constructor(){
    var gastos = ArrayList<GastoEntity>()
    companion object{
        val instance = GastoModel()
    }
    private lateinit var context: Context
    private lateinit var database: DbFinance
    fun setContext(context: Context){
        this.context = context
        database = DbFinance(context)
        gastos = database.retrieveGastosFromDB()
    }
    fun addGasto(gasto: GastoEntity){
        val id = database.createGastoInDB(gasto)
        if(id > 0){
            gastos = database.retrieveGastosFromDB()
        }else{
            TODO("tratar erro")
        }
    }

}