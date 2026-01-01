package com.ext.tableview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.model.TableCell
import com.ext.tableview.model.TableRow
import com.ext.tableview.model.TableStyle

class HeaderAdapter(
    private val headerRow: TableRow
) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    private lateinit var style: TableStyle

    internal fun setStyle(style: TableStyle) {
        this.style = style
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val rv = RecyclerView(parent.context).apply {
            layoutManager = LinearLayoutManager(
                parent.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        return HeaderViewHolder(rv)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(headerRow.cells, style)
    }

    override fun getItemCount(): Int = 1

    class HeaderViewHolder(
        private val recyclerView: RecyclerView
    ) : RecyclerView.ViewHolder(recyclerView) {

        fun bind(
            cells: List<TableCell>,
            style: TableStyle
        ) {
            recyclerView.adapter = RowAdapter(
                cells = cells,
                rowIndex = 0,
                listener = null,
                style = style
            )
        }
    }
}
