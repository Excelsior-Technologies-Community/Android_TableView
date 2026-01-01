package com.ext.tableview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.tableview.adapter.HeaderAdapter
import com.ext.tableview.adapter.TableAdapter
import com.ext.tableview.listener.OnCellClickListener
import com.ext.tableview.model.TableStyle

class TableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val headerRecyclerView = RecyclerView(context)
    private val bodyRecyclerView = RecyclerView(context)

    private var tableAdapter: TableAdapter? = null
    private var cellClickListener: OnCellClickListener? = null
    private var tableStyle = TableStyle()

    init {
        orientation = VERTICAL

        attrs?.let {
            val ta = context.obtainStyledAttributes(it, R.styleable.TableView)
            tableStyle = TableStyle(
                cellTextSize = ta.getDimension(
                    R.styleable.TableView_cellTextSize,
                    tableStyle.cellTextSize
                ),
                cellPadding = ta.getDimensionPixelSize(
                    R.styleable.TableView_cellPadding,
                    tableStyle.cellPadding
                ),
                headerBackground = ta.getColor(
                    R.styleable.TableView_headerBackground,
                    tableStyle.headerBackground
                ),
                dividerColor = ta.getColor(
                    R.styleable.TableView_dividerColor,
                    tableStyle.dividerColor
                )
            )
            ta.recycle()
        }

        setupHeader()
        setupBody()
        setupLayout()
        syncHorizontalScroll()
    }


    private fun setupHeader() {
        headerRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupBody() {
        bodyRecyclerView.layoutManager =
            LinearLayoutManager(context)
        bodyRecyclerView.setHasFixedSize(true)
    }

    private fun setupLayout() {
        addView(
            headerRecyclerView,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        )

        addView(
            bodyRecyclerView,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            )
        )
    }


    private fun syncHorizontalScroll() {
        bodyRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                headerRecyclerView.scrollBy(dx, 0)
            }
        })
    }

    fun setTableAdapter(adapter: TableAdapter) {
        tableAdapter = adapter
        adapter.setCellClickListener(cellClickListener)
        adapter.setTableStyle(tableStyle)
        bodyRecyclerView.adapter = adapter
    }

    fun setOnCellClickListener(listener: OnCellClickListener) {
        cellClickListener = listener
        tableAdapter?.setCellClickListener(listener)
    }

    fun setHeaderAdapter(adapter: HeaderAdapter) {
        adapter.setStyle(tableStyle)
        headerRecyclerView.adapter = adapter
    }


}
