package com.example.employeedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class MainActivity : AppCompatActivity()
{
    val databaseHelper by lazy{EmployeeDatabaseHelper(this)}
    var delayHandler : Handler? = null
    val splashDelay : Long = 3500
    internal val isRunning : Runnable = Runnable{
        if(!isFinishing)
        {
            startActivity(Intent(this, FilterEmployeeActivity::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(databaseHelper.getAllDepartmentFromDatabase().isEmpty())
        {
            databaseHelper.insertEmployeeIntoDatabase(
                Employee("Andrew",
                    "Millsap",
                    "123 Vancouver Dr.",
                    "Westerville",
                    "Ohio",
                    "43081",
                    "12345",
                    "Developer",
                    "IT")
            )
            databaseHelper.insertEmployeeIntoDatabase(
                Employee("Dave",
                    "Buster",
                    "4829 Person Lane",
                    "Atlanta",
                    "Georgia",
                    "11213",
                    "67894",
                    "Janitor",
                    "Maintenance"))
            databaseHelper.insertDepartmentToDatabase("IT")
            databaseHelper.insertDepartmentToDatabase("Maintenance")
            databaseHelper.insertDepartmentToDatabase(("Marketing"))
        }

        delayHandler = Handler()
        delayHandler!!.postDelayed(isRunning, splashDelay)

        //startActivity(Intent(this, FilterEmployeeActivity::class.java))
        //intent = Intent(this, FilterEmployeeActivity::class.java)

    }

    override fun onDestroy() {
        super.onDestroy()
        if(delayHandler != null)
        {
            delayHandler!!.removeCallbacks(isRunning)
        }
    }
}
