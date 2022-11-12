package com.example.notescart.Activity

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notescart.R
import kotlinx.android.synthetic.main.addnotedialog.*
import kotlinx.android.synthetic.main.addnotedialog.view.*
import kotlinx.android.synthetic.main.delete_dialog.*
import kotlinx.android.synthetic.main.delete_edit_option_dialog.*
import kotlinx.android.synthetic.main.row_item.*
import kotlinx.android.synthetic.main.row_item.description
import kotlinx.android.synthetic.main.row_item.titles
import kotlinx.android.synthetic.main.row_item.view.*
import kotlinx.android.synthetic.main.row_item.view.description
import kotlinx.android.synthetic.main.row_item.view.titles

class RecycleViewAdapter(val context: Context, val arrData: ArrayList<DBModel>) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    class ViewHolder(val itemviews: View) : RecyclerView.ViewHolder(itemviews) {
        val title = itemviews.titles
        val description = itemviews.description

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewholder = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(viewholder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = arrData[position].Name
        holder.description.text = arrData[position].Email

        holder.itemviews.setOnLongClickListener {
            var t = holder.itemviews.titles.text
            var d = holder.itemviews.description.text
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.delete_edit_option_dialog)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//            dialog.setContentView(R.layout.addnotedialog)
            dialog.close_btn.setOnClickListener {
                dialog.dismiss()
            }
            dialog.edit_btn.setOnClickListener {
                val Edit_Dialog = Dialog(context)
                Edit_Dialog.setContentView(R.layout.addnotedialog)
                Edit_Dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                Edit_Dialog.setCancelable(false)
                Edit_Dialog.titles.text = t
                Edit_Dialog.description.text = d
                Edit_Dialog.cancel_btn.setOnClickListener {
                    Edit_Dialog.dismiss()
                }
                Edit_Dialog.save_btn.setOnClickListener {
                    val titles = Edit_Dialog.titles.text.toString()
                    val description = Edit_Dialog.description.text.toString()

                    (context as MainActivity).updatenote(
                        DBModel(
                            arrData[position].Id,
                            titles,
                            description
                        )
                    )
                    dialog.dismiss()
                    Edit_Dialog.dismiss()

                }
                Edit_Dialog.show()
            }

            dialog.delete_btn.setOnClickListener {
                val delete_dialog = Dialog(context)
                delete_dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                delete_dialog.setCancelable(false)
                delete_dialog.setContentView(R.layout.delete_dialog)
                delete_dialog.show()
                delete_dialog.delete_dialog_cancel_btn.setOnClickListener {
                    delete_dialog.dismiss()
                }
                delete_dialog.delete_dialog_delete_btn.setOnClickListener {
                    (context as MainActivity).deleteNote(arrData[position].Id)
                    delete_dialog.dismiss()
                    dialog.dismiss()
                }
            }
            dialog.show()

            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return arrData.size
    }
}