package com.example.employeedatabase

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_employee_list.*

class EmployeeListActivity : AppCompatActivity(), EmployeeAdapterCallback
{
    //private lateinit var appBarConfiguration: AppBarConfiguration
    var departmentName : String = ""
    lateinit var adapter: EmployeeAdapter
    //var  adapter by lazy{EmployeeAdapter(list)}
    var list : ArrayList<Employee> = ArrayList<Employee>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        /*val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
        departmentName = intent.getStringExtra(KEY_EMPLOYEE)
        var list = Array<String>(1) {departmentName}

        val cursor = contentResolver.query(CONTENT_URI, null, null, list, null)
        val employeeList = ArrayList<Employee>()
        if(cursor!!.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP_CODE))
                val taxId = cursor.getString(cursor.getColumnIndex(COL_TAX_ID))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val employee = Employee(firstName, lastName, address, city, state, zip, taxId, position, department)
                employeeList.add(employee)
            } while(cursor.moveToNext())
        }

        cursor.close()
        adapter = EmployeeAdapter(employeeList)
        initRecyclerView()
        adapter.updateList(employeeList)
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.employee_list, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }*/

    private fun initRecyclerView()
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvEmployeeList.layoutManager = layoutManager
        rvEmployeeList.addItemDecoration((itemDecoration))
        rvEmployeeList.adapter = adapter
    }

    override fun passAdapter(adapter: EmployeeAdapter)
    {
        departmentName = intent.getStringExtra(KEY_EMPLOYEE)
        var list = Array(1) {departmentName}
        val cursor = contentResolver.query(CONTENT_URI, null, null, list, null)
        val employeeList = ArrayList<Employee>()
        if(cursor!!.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val address = cursor.getString(cursor.getColumnIndex(COL_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP_CODE))
                val taxId = cursor.getString(cursor.getColumnIndex(COL_TAX_ID))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val employee = Employee(firstName, lastName, address, city, state, zip, taxId, position, department)
                employeeList.add(employee)
            } while(cursor.moveToNext())
        }

        cursor.close()
        adapter.updateList((employeeList))
    }
}
