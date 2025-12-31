package com.ext.tableview.listener

import com.ext.tableview.model.TableCell

fun interface OnCellClickListener {
    fun onCellClick(row: Int, column: Int, cell: TableCell)
}