package com.ext.tableview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.listener.OnCellClickListener
import com.ext.tableview.model.TableCell
import com.ext.tableview.model.TableStyle

class RowAdapter(
    private val cells: List<TableCell>,
    private val rowIndex: Int,
    private val listener: OnCellClickListener?,
    private val style: TableStyle
) : RecyclerView.Adapter<RowAdapter.CellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val textView = TextView(parent.context)
        return CellViewHolder(textView)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.bind(cells[position], rowIndex, position, listener, style)
    }

    override fun getItemCount(): Int = cells.size

    class CellViewHolder(private val textView: TextView) :
        RecyclerView.ViewHolder(textView) {

        fun bind(
            cell: TableCell,
            row: Int,
            col: Int,
            listener: OnCellClickListener?,
            style: TableStyle
        ) {
            textView.text = cell.value
            textView.textSize = style.cellTextSize / textView.resources.displayMetrics.scaledDensity
            textView.setPadding(
                style.cellPadding,
                style.cellPadding,
                style.cellPadding,
                style.cellPadding
            )
            textView.setOnClickListener {
                listener?.onCellClick(row, col, cell)
            }
        }
    }
}
