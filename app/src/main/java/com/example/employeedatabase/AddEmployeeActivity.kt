package com.example.employeedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_filter_employee.*

class AddEmployeeActivity : AppCompatActivity(), EmployeeAdapterCallback {
    val database by lazy { EmployeeDatabaseHelper(this) }
    val passedEmployee by lazy {intent?.getParcelableExtra<Employee>(KEY_EMPLOYEE)}

    override fun passAdapter(adapter: EmployeeAdapter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        etFirstNameInput.setText(passedEmployee?.firstName)
        etLastNameInput.setText(passedEmployee?.lastName)
        etAddressInput.setText(passedEmployee?.address)
        etCityInput.setText(passedEmployee?.city)
        etStateNameInput.setText(passedEmployee?.state)
        etZipCodeNameInput.setText(passedEmployee?.zipCode)
        etTaxIDInput.setText(passedEmployee?.taxID)
        etPositionInput.setText(passedEmployee?.position)
        etDepartmentInput.setText(passedEmployee?.department)

    }

    fun addEmployeeToDatabase(view: View)
    {
        database.insertEmployeeIntoDatabase(Employee(etFirstNameInput.text.toString(),
                                                    etLastNameInput.text.toString(),
                                                    etAddressInput.text.toString(),
                                                    etCityInput.text.toString(),
                                                    etStateNameInput.text.toString(),
                                                    etZipCodeNameInput.text.toString(),
                                                    etTaxIDInput.text.toString(),
                                                    etPositionInput.text.toString(),
                                                    etDepartmentInput.text.toString()))
        val toast =
            Toast.makeText(applicationContext, "Employee Added To Database", Toast.LENGTH_LONG)
        toast.show()
        val intent = Intent(this, FilterEmployeeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun updateEmployeeToDatabase(view: View)
    {
        database.updateEmployeeInDatabase(Employee(etFirstNameInput.text.toString(),
                                                    etLastNameInput.text.toString(),
                                                    etAddressInput.text.toString(),
                                                    etCityInput.text.toString(),
                                                    etStateNameInput.text.toString(),
                                                    etZipCodeNameInput.text.toString(),
                                                    etTaxIDInput.text.toString(),
                                                    etPositionInput.text.toString(),
                                                    etDepartmentInput.text.toString())
        )

        val toast =
            Toast.makeText(applicationContext, "Employee Updated In Database", Toast.LENGTH_LONG)
        toast.show()
        val intent = Intent(this, FilterEmployeeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
