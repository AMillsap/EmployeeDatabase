package com.example.employeedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_employee_description.*
import kotlinx.android.synthetic.main.activity_filter_employee.*

class EmployeeDescriptionActivity : AppCompatActivity()
{
    val database by lazy { EmployeeDatabaseHelper(this) }
    val passedEmployee by lazy {intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_description)
        tvEmployeeFirstName.text = "First name: " + passedEmployee?.firstName
        tvEmployeeLastName.text = "Last name: " + passedEmployee?.lastName
        tvEmployeeAddress.text = "Address: " + passedEmployee?.address
        tvEmployeeCity.text = "City: " + passedEmployee?.city
        tvEmployeeState.text = "State: " + passedEmployee?.state
        tvEmployeeZip.text = "Zip Code: " + passedEmployee?.zipCode
        tvEmployeeTaxID.text = "TaxID: " + passedEmployee?.taxID
        tvEmployeePosition.text = "Position: " + passedEmployee?.position
        tvEmployeeDepartment.text = "Department: " + passedEmployee?.department

    }

    fun onCLick(view: View)
    {
        when(view.id)
        {
            R.id.btnDeleteEmployeeToDatabase ->
            {
                database.removeEmployeeFromDatabase(passedEmployee?.taxID.toString())
                val toast =
                    Toast.makeText(applicationContext, "Employee Deleted To Database", Toast.LENGTH_LONG)
                toast.show()
                val intent = Intent(this, FilterEmployeeActivity::class.java)
                startActivity(intent)
            }
            R.id.btnUpdateEmployeeToDatabase ->
            {
                val intent = Intent(this, AddEmployeeActivity::class.java)
                intent.putExtra(KEY_EMPLOYEE, passedEmployee)
                startActivity(intent)
                finish()
            }
        }

    }
}
