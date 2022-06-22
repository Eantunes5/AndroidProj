package com.example.appfinanca.model

import android.content.Context
import com.example.appfinanca.db.DbFinance
import com.example.appfinanca.entity.GanhoEntity
import com.example.appfinanca.entity.GastoEntity

class GanhoModel private constructor(){
    var ganhos = ArrayList<GanhoEntity>()
    companion object{
        val instance = GanhoModel()
    }
    private lateinit var context: Context
    private lateinit var database:DbFinance
    fun setContext(context: Context){
        this.context = context
        database = DbFinance(context)
        ganhos = database.retrieveGanhosFromDB()
    }
    fun addGanho(ganho: GanhoEntity){
        val id = database.createGanhoInDB(ganho)
        if(id > 0){
            ganhos = database.retrieveGanhosFromDB()
        }else{
            TODO("tratar erro")
        }
    }

    fun updateGanho(ganho: GanhoEntity){
        val count = database.updateGanhoInDB(ganho)
        if(count > 0){
            ganhos = database.retrieveGanhosFromDB()
        }
    }
    fun removeGanho(ganho: GanhoEntity){
        val count = database.removeGanhoInDB(ganho)
        if(count > 0){
            ganhos = database.retrieveGanhosFromDB()
        }
    }

}