package com.example.employeedatabase

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_filter_employee.*
import java.util.ArrayList

class FilterEmployeeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_employee)

        val database = EmployeeDatabaseHelper(this)
        val spinner: Spinner = findViewById(R.id.spSelection)
        spinner.onItemSelectedListener = this
        var arrayOfDept  = database.getAllDepartmentFromDatabase()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOfDept)
        spinner.adapter = adapter



    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
    }

    fun searchDept(view: View)
    {
        val intent = Intent(this, EmployeeListActivity::class.java)
        intent.putExtra(KEY_EMPLOYEE,spSelection.selectedItem.toString())
        startActivity(intent)
    }

}

