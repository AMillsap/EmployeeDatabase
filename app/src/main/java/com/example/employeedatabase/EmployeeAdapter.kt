package com.example.employeedatabase

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employee_item.view.*

class EmployeeAdapter(var employeeList : ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.populateItem(employeeList[position])
    }

    override fun getItemCount() = employeeList.size

    fun updateList(passedList : ArrayList<Employee>) {
        employeeList = passedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun populateItem(employee: Employee)
        {
            itemView.tvFirstName.text = employee.firstName
            itemView.tvLastName.text = employee.lastName
            itemView.setOnClickListener {
                val intent = Intent(it.context, EmployeeDescriptionActivity::class.java)
                intent.putExtra(KEY_EMPLOYEE, employee)
                it.context.startActivity(intent)
            }
        }

    }
}