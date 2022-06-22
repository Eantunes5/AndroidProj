package com.example.appfinanca.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appfinanca.entity.GanhoEntity
import com.example.appfinanca.entity.GastoEntity

class DbFinance(context:Context):
    SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object{
        private const val DB_NAME = "finance.sqlite"
        private const val DB_VERSION = 1
        private const val DB_TABLE = "ganho"
        private const val DB_TABLE2 = "gasto"
        private const val COL_ID = "id"
        private const val COL_VALUE = "valor"

    }

    override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
        val query = "create table if not exists $DB_TABLE (" +
                "$COL_ID integer primary key autoincrement," +
                "$COL_VALUE text)"
        sqliteDatabase?.execSQL(query)
        val query2 = "create table if not exists $DB_TABLE2 (" +
                "$COL_ID integer primary key autoincrement," +
                "$COL_VALUE text)"
        sqliteDatabase?.execSQL(query2)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun createGastoInDB(gasto: GastoEntity) : Long{
        val database = writableDatabase
        val values = ContentValues()
        values.put(COL_VALUE,gasto.valor)
        val id = database.insert(DB_TABLE2,null,
            values)
        database.close()
        return id
    }

    fun createGanhoInDB(ganho: GanhoEntity) : Long{
        val database = writableDatabase
        val values = ContentValues()
        values.put(COL_VALUE,ganho.valor)
        val id = database.insert(DB_TABLE,null,
            values)
        database.close()
        return id
    }

    fun retrieveGastosFromDB():ArrayList<GastoEntity>{
        var gastos = ArrayList<GastoEntity>()
        val cursor = readableDatabase.query(DB_TABLE2,
            null,null,null,null,
            null,null)
        if(cursor.moveToFirst()){
            do{
                val id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(COL_ID))
                val valor = cursor.getString(
                    cursor.getColumnIndexOrThrow(COL_VALUE))
                gastos.add(GastoEntity(id,valor))
            }while (cursor.moveToNext())
        }
        readableDatabase.close()
        return gastos
    }

    fun retrieveGanhosFromDB():ArrayList<GanhoEntity>{
        var ganhos = ArrayList<GanhoEntity>()
        val cursor = readableDatabase.query(DB_TABLE,
            null,null,null,null,
            null,null)
        if(cursor.moveToFirst()){
            do{
                val id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(COL_ID))
                val valor = cursor.getString(
                    cursor.getColumnIndexOrThrow(COL_VALUE))
                ganhos.add(GanhoEntity(id,valor))
            }while (cursor.moveToNext())
        }
        readableDatabase.close()
        return ganhos
    }

}