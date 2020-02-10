package com.example.employeedatabase

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employee (var  firstName : String,
                     var lastName : String,
                     var address : String,
                     var city : String,
                     var state : String,
                     var zipCode : String,
                     var taxID : String,
                     var position :String,
                     var department : String) : Parcelable