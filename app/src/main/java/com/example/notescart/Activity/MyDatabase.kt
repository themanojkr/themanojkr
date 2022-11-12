package com.example.notescart.Activity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DBModel::class), version = 1, exportSchema = false)
abstract class MyDatabase:RoomDatabase(){
    abstract fun AdoModel():ADOModel
    companion object {
        val INSTANCE: MyDatabase? =null

        fun getDatabase(context: Context): MyDatabase {
            if (INSTANCE != null) {
                return INSTANCE
            } else {
                 synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                       MyDatabase::class.java,
                        "DBnote"
                    ).allowMainThreadQueries().build()
                    return instance
                }
            }
        }

    }
}