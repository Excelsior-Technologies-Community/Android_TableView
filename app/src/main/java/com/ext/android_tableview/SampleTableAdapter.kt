package com.ext.android_tableview

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.adapter.RowAdapter
import com.ext.tableview.adapter.TableAdapter

class SampleTableAdapter : TableAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val recyclerView = RecyclerView(parent.context).apply {
            layoutManager = LinearLayoutManager(
                parent.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        return RowViewHolder(recyclerView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val row = rows[position]
        (holder as RowViewHolder).bind(row.cells)
    }

    class RowViewHolder(
        private val recyclerView: RecyclerView
    ) : RecyclerView.ViewHolder(recyclerView) {

        fun bind(cells: List<com.ext.tableview.model.TableCell>) {
            recyclerView.adapter = RowAdapter(cells)
        }
    }
}
