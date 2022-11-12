package com.example.notescart.Activity

import android.app.Dialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notescart.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.addnotedialog.*

class MainActivity : AppCompatActivity() {
lateinit var getarr:ArrayList<DBModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNote()
//        updateDate()
        NoteCheck()
         val addBtnDialog = Dialog(this)
        addBtnDialog.setContentView(R.layout.addnotedialog)
        addBtnDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        addBtnDialog.setCancelable(false)
  MyDatabase.getDatabase(this).AdoModel().deleteNote(1)
//        AddVAluesInDarray("Today","Happy Diwali")

        add_btn.setOnClickListener{

            addBtnDialog.show()
        }
       addBtnDialog.save_btn.setOnClickListener {
           val Titles = addBtnDialog.titles.text.toString()
           val descriptions = addBtnDialog.description.text.toString()
           if (Titles!="" && descriptions!=""){
               MyDatabase.getDatabase(this).AdoModel().insertNote(DBModel(0,Titles,descriptions))
               getNote()
               NoteCheck()
               addBtnDialog.dismiss()
           }

       }
        addBtnDialog.cancel_btn.setOnClickListener {
            addBtnDialog.dismiss()
        }
    }

    private fun NoteCheck() {
        if (getarr.isEmpty()){
            search.visibility =View.GONE
            background_ui.visibility =View.VISIBLE
        }else{
            search.visibility = View.VISIBLE
            background_ui.visibility =View.GONE
        }
    }

    fun updatenote(note:DBModel) {
    MyDatabase.getDatabase(this).AdoModel().updateNote(note)
        getNote()
    }

    private fun getNote() {
        getarr = MyDatabase.getDatabase(this).AdoModel().geData() as ArrayList<DBModel>
        recycle_View.adapter = RecycleViewAdapter(this,getarr)
        recycle_View.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
    }
fun deleteNote(id:Int){
    MyDatabase.getDatabase(this).AdoModel().deleteNote(id)
    getNote()
    NoteCheck()
}

}










