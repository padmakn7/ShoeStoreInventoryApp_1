package com.udacity.shoestore.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//data class is used to hold the data
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<Int> = mutableListOf())