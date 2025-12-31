package com.ext.tableview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.model.TableRow

abstract class TableAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val rows = mutableListOf<TableRow>()

    fun submitList(data: List<TableRow>) {
        rows.clear()
        rows.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = rows.size
}