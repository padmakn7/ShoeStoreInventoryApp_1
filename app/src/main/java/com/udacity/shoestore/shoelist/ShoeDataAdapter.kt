//package com.udacity.shoestore
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import androidx.lifecycle.LiveData
//import com.udacity.shoestore.databinding.ShoeItemBinding
//import com.udacity.shoestore.models.Shoe
//
//class ShoeDataAdapter(
//    context: Context,
//    private val shoeDataList : MutableList<Shoe>
//) : ArrayAdapter<Shoe>(context, 0, shoeDataList) {
//
//    override fun getCount(): Int {
//        return shoeDataList.size
//    }
//
//    override fun getItem(position: Int): Shoe? {
//        return shoeDataList.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//        val binding: ShoeItemBinding
//        if (convertView == null) {
//            val inflater = LayoutInflater.from(context)
//            binding = ShoeItemBinding.inflate(inflater, parent, false)
//            binding.root.tag = binding
//        } else {
//            binding = convertView.tag as ShoeItemBinding
//        }
//
//        val shoeData = shoeDataList[position]
//        binding.shoeData = shoeData
//        binding.executePendingBindings()
//
//        binding.shoeIv1.setImageResource(shoeDataList[position].images[0])
//        binding.shoeIv2.setImageResource(shoeDataList[position].images[1])
//
//
//
//        return binding.root
//
//
//    }
//}