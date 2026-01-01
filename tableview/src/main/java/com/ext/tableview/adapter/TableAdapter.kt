package com.ext.tableview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.listener.OnCellClickListener
import com.ext.tableview.model.TableRow
import com.ext.tableview.model.TableStyle

abstract class TableAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val rows = mutableListOf<TableRow>()
    protected var cellClickListener: OnCellClickListener? = null
    protected lateinit var tableStyle: TableStyle

    internal fun setCellClickListener(listener: OnCellClickListener?) {
        cellClickListener = listener
    }

    fun submitList(data: List<TableRow>) {
        rows.clear()
        rows.addAll(data)
        notifyDataSetChanged()
    }

    fun getHeaderRow(): TableRow? {
        return rows.firstOrNull()
    }

    fun getBodyRows(): List<TableRow> {
        return if (rows.size > 1) rows.drop(1) else emptyList()
    }
    internal fun setTableStyle(style: TableStyle) {
        tableStyle = style
    }

    override fun getItemCount(): Int = getBodyRows().size
}
