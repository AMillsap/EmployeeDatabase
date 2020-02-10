package com.example.employeedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_remove_employee.*

class RemoveEmployeeActivity : AppCompatActivity()
{
    val database by lazy { EmployeeDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_employee)
    }

    fun deleteEmployee(view: View)
    {
        database.removeEmployeeFromDatabase(etRemoveEmployee.text.toString())

        val toast =
            Toast.makeText(applicationContext, "Employee Removed To Database", Toast.LENGTH_LONG)
        toast.show()
        finish()
    }
}
