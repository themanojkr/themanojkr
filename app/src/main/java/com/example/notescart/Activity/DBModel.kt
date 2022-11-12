package com.example.notescart.Activity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteList")
data class DBModel(@PrimaryKey(autoGenerate = true) val Id:Int,
                                                    val Name:String,
                                                     val Email:String)
