package com.ext.tableview


import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.adapter.TableAdapter

class TableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        layoutManager = LinearLayoutManager(context)
        setHasFixedSize(true)
    }

    fun setTableAdapter(adapter: TableAdapter) {
        this.adapter = adapter
    }
}
