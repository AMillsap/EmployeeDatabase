package com.example.employeedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmployeeDatabaseHelper(context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    override fun onCreate(sqLightDatabase: SQLiteDatabase?)
    {
        sqLightDatabase?.execSQL(CREATE_EMPLOYEE_TABLE)
        sqLightDatabase?.execSQL(CREATE_DEPARTMENT_TABLE)
    }

    override fun onUpgrade(sqLightDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        onCreate(sqLightDatabase)
    }

    fun insertEmployeeIntoDatabase(employee: Employee){
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME, employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_ADDRESS, employee.address)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP_CODE, employee.zipCode)
        contentValues.put(COL_TAX_ID, employee.taxID)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_DEPARTMENT, employee.department)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }

    fun updateEmployeeInDatabase(employee: Employee) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_ADDRESS, employee.address)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP_CODE, employee.zipCode)
        contentValues.put(COL_TAX_ID, employee.taxID)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_DEPARTMENT, employee.department)

        database.update(TABLE_NAME, contentValues, "$COL_TAX_ID = ?", arrayOf(employee.taxID))
        database.close()
    }

    fun getEmployeeFromDatabase(departmentName : String) : ArrayList<Employee>
    {
        val database = readableDatabase
        var employeeList : ArrayList<Employee> = ArrayList<Employee>()
        var employee:Employee? = null
        val cursor = database.
                rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_DEPARTMENT='$departmentName'", null)

        if(cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP_CODE))
                val taxID = cursor.getString(cursor.getColumnIndex(COL_TAX_ID))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                employee = Employee(firstName, lastName, address, city, state, zip, taxID, position, department)
                employeeList.add(employee)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return employeeList
    }

    fun removeEmployeeFromDatabase(taxID : String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_TAX_ID = ?", arrayOf(taxID))
        database.close()
    }

    fun insertDepartmentToDatabase(string: String)
    {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_DEPARTMENT, string)

        database.insert(TABLE_NAME2,null, contentValues)
        database.close()
    }

    fun getAllDepartmentFromDatabase() : ArrayList<String> {
        val database = readableDatabase
        var departmentList : ArrayList<String> = ArrayList<String>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME2",
                null)

        if(cursor.moveToFirst()) {
            do {
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                departmentList.add(department)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return departmentList
    }

    fun getAllEmployeesFromDatabase() : ArrayList<Employee> {
        val database = readableDatabase
        var employeeList : ArrayList<Employee> = ArrayList<Employee>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME",
                null)

        if(cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP_CODE))
                val taxID = cursor.getString(cursor.getColumnIndex(COL_TAX_ID))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val employee = Employee(firstName, lastName, address, city, state, zip, taxID, position, department)
                employeeList.add(employee)
                employeeList.add(employee)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return employeeList
    }
}