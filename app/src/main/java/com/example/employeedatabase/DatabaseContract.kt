package com.example.employeedatabase

const val DATABASE_NAME = "employee_database"
const val TABLE_NAME = "employee_table"
const val TABLE_NAME2 = "department_table"
const val DATABASE_VERSION = 1
const val COL_FIRST_NAME = "first_name"
const val COL_LAST_NAME = "last_name"
const val COL_ADDRESS = "address"
const val COL_CITY = "city"
const val COL_STATE = "state"
const val COL_ZIP_CODE = "zip_code"
const val COL_TAX_ID = "tax_id"
const val COL_POSITION = "position"
const val COL_DEPARTMENT = "department"

const val CREATE_EMPLOYEE_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_FIRST_NAME String," +
            "$COL_LAST_NAME String," +
            "$COL_ADDRESS String," +
            "$COL_CITY String," +
            "$COL_STATE String," +
            "$COL_ZIP_CODE String," +
            "$COL_TAX_ID String PRIMARY_KEY," +
            "$COL_POSITION String," +
            "$COL_DEPARTMENT String)"

const val CREATE_DEPARTMENT_TABLE =
    "CREATE TABLE $TABLE_NAME2 (" +
            "$COL_DEPARTMENT String PRIMARY_KEY)"