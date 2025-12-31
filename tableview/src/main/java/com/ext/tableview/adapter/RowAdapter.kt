package com.ext.tableview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.model.TableCell

class RowAdapter(
    private val cells: List<TableCell>
) : RecyclerView.Adapter<RowAdapter.CellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val textView = TextView(parent.context).apply {
            setPadding(32, 24, 32, 24)
        }
        return CellViewHolder(textView)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.bind(cells[position])
    }

    override fun getItemCount(): Int = cells.size

    class CellViewHolder(
        private val textView: TextView
    ) : RecyclerView.ViewHolder(textView) {

        fun bind(cell: TableCell) {
            textView.text = cell.value
        }
    }
}
