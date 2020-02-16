package com.example.employeedatabase

import android.content.ContentValues
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
        var newValues = ContentValues().apply { put(COL_FIRST_NAME, etFirstNameInput.text.toString())
                                                put(COL_LAST_NAME, etLastNameInput.text.toString())
                                                put(COL_ADDRESS, etAddressInput.text.toString())
                                                put(COL_CITY, etCityInput.text.toString())
                                                put(COL_STATE, etStateNameInput.text.toString())
                                                put(COL_ZIP_CODE, etStateNameInput.text.toString())
                                                put(COL_TAX_ID, etTaxIDInput.text.toString())
                                                put(COL_POSITION, etPositionInput.text.toString())
                                                put(COL_DEPARTMENT, etDepartmentInput.text.toString())}
        contentResolver.insert(CONTENT_URI, newValues)

        val toast =
            Toast.makeText(applicationContext, "Employee Added To Database", Toast.LENGTH_LONG)
        toast.show()
        val intent = Intent(this, FilterEmployeeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun updateEmployeeToDatabase(view: View)
    {
        var newValues = ContentValues().apply { put(COL_FIRST_NAME, etFirstNameInput.text.toString())
            put(COL_LAST_NAME, etLastNameInput.text.toString())
            put(COL_ADDRESS, etAddressInput.text.toString())
            put(COL_CITY, etCityInput.text.toString())
            put(COL_STATE, etStateNameInput.text.toString())
            put(COL_ZIP_CODE, etStateNameInput.text.toString())
            put(COL_TAX_ID, etTaxIDInput.text.toString())
            put(COL_POSITION, etPositionInput.text.toString())
            put(COL_DEPARTMENT, etDepartmentInput.text.toString())}
        contentResolver.update(CONTENT_URI, newValues, etTaxIDInput.text.toString(),null)

        /*database.updateEmployeeInDatabase(Employee(etFirstNameInput.text.toString(),
                                                    etLastNameInput.text.toString(),
                                                    etAddressInput.text.toString(),
                                                    etCityInput.text.toString(),
                                                    etStateNameInput.text.toString(),
                                                    etZipCodeNameInput.text.toString(),
                                                    etTaxIDInput.text.toString(),
                                                    etPositionInput.text.toString(),
                                                    etDepartmentInput.text.toString())
        )*/

        val toast =
            Toast.makeText(applicationContext, "Employee Updated In Database", Toast.LENGTH_LONG)
        toast.show()
        val intent = Intent(this, FilterEmployeeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
