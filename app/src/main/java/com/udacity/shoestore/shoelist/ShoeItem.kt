package com.udacity.shoestore.shoelist

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.udacity.shoestore.R

class ShoeItem : LinearLayout{
    private lateinit var shoeProductImage_iv1: ImageView
    private lateinit var shoeProductImage_iv2: ImageView
    private lateinit var shoeProductName_tv: TextView
    private lateinit var shoeProductDesc_tv: TextView
    private lateinit var shoeCompanyName_tv: TextView
    private lateinit var shoeProductSize_tv: TextView

    constructor(context: Context?) : super(context)
    {
        initialize()
    }


    private fun initialize() {
        LayoutInflater.from(context)
            .inflate(R.layout.shoe_item, this)
        shoeProductImage_iv1 = findViewById(R.id.shoe_iv_1)
        shoeProductImage_iv2 = findViewById(R.id.shoe_iv_2)
        shoeProductName_tv = findViewById(R.id.shoe_name_tv)
        shoeCompanyName_tv = findViewById(R.id.shoe_company_name_tv)
        shoeProductSize_tv = findViewById(R.id.shoe_size_tv)
        shoeProductDesc_tv = findViewById(R.id.shoe_desc_tv)

    }

    fun setProduct(image1: Int, image2 :Int, productName: String,companyName: String, productSize: Double,
                   productDescription: String) {
        shoeProductImage_iv1.setImageResource(image1)
        shoeProductImage_iv2.setImageResource(image2)
        shoeProductName_tv.text = productName
        shoeCompanyName_tv.text = companyName
        shoeProductSize_tv.text = productSize.toString()
        shoeProductDesc_tv.text = productDescription

    }
}

