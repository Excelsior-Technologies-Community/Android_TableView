package com.ext.android_tableview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.tableview.TableView
import com.ext.tableview.model.TableCell
import com.ext.tableview.model.TableRow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tableView = findViewById<TableView>(R.id.tableView)
        val adapter = SampleTableAdapter()

        tableView.setTableAdapter(adapter)

        adapter.submitList(createDummyData())
    }
    private fun createDummyData(): List<TableRow> {
        return List(20) { row ->
            TableRow(
                cells = List(6) { col ->
                    TableCell("R$row C$col")
                }
            )
        }
    }
}