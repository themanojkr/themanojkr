package com.example.notescart.Activity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ADOModel {
   @Insert
    fun insertNote(dbModel: DBModel)

    @Query("select * from NoteList")
    fun geData():List<DBModel>

    @Update
    fun updateNote(noteList: DBModel)

    @Query("delete from NoteList where id =:id")
    fun deleteNote(id:Int)
}