package com.ext.android_tableview

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.TableView
import com.ext.tableview.adapter.RowAdapter
import com.ext.tableview.adapter.TableAdapter
import com.ext.tableview.listener.OnCellClickListener
import com.ext.tableview.model.TableCell
import com.ext.tableview.model.TableStyle

class SampleTableAdapter : TableAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rv = RecyclerView(parent.context).apply {
            layoutManager = LinearLayoutManager(
                parent.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        return RowViewHolder(rv)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val row = getBodyRows()[position]
        (holder as RowViewHolder).bind(
            row.cells,
            position + 1, // real row index
            cellClickListener,
            tableStyle
        )
    }

    class RowViewHolder(private val recyclerView: RecyclerView) :
        RecyclerView.ViewHolder(recyclerView) {

        fun bind(
            cells: List<TableCell>,
            rowIndex: Int,
            listener: OnCellClickListener?,
            style: TableStyle
        ) {
            recyclerView.adapter = RowAdapter(
                cells,
                rowIndex,
                listener,
                style
            )
        }
    }
}
