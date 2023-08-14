package com.udacity.shoestore.shoedetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.sharedviewmodelShoeListAndShoeDetail.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
    // Access the same ViewModel instance as the activity
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)


        Log.i("ShoeDetailsFragment", "called viewmodelprovider")

        // You don't need to manually create the ViewModel, just
        // use viewModel
        // Now you can use the viewModel directly to access the
        // list of shoes or other ViewModel functions
        // viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.saveDetailsBtn.setOnClickListener { view : View ->
            if(binding.shoeNameEt.text.isNotBlank() && binding.shoeSizeEt.text.isNotBlank()
                && binding.companyNameEt.text.isNotBlank() && binding.shoeDescEt.text.isNotBlank()) {
                val newShoe = Shoe(
                    binding.shoeNameEt.text.toString(),
                    binding.shoeSizeEt.text.toString().toDouble(),
                    binding.companyNameEt.text.toString(),
                    binding.shoeDescEt.text.toString(),
                    mutableListOf(R.drawable.shoe_image_3_1, R.drawable.shoe_image_3_2)
                )

                //shoe details to enter :
                //name -> Womens Walking Running Shoes Athletic Blade Non Slip Tennis Fashion Sneakers
                //size -> 5.5
                //company -> Wonesion
                //shoe desc -> mesh
                //Rubber sole
                //【UPPER】Fashion knitted mesh material and lightweight support maximizes the upper and let your foot always keeps dry and cool.
                //【OUTSOLES】The sole Is made of hollow carved technology, providing stable support and optimal shock absorption for sport.
                //【INSOLE】The insole adopt honeycomb hole design, Keep your feet balanced and protect your ankle ,tongues and feet from hurt.
                //【Applications】Better for working, training, running, walking, tennis, athletic, gym, sports, golf, indoor & outdoot, hiking, camping, climbing, travel, etc.
                //The shoes adopt stylish color scheme gives you a different visual experience. Breathable and durable. Simple style, all-match colors, can be match any clothing.
                viewModel.addShoe(newShoe)
                view.findNavController()
                    .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeListFragment())
            }     else {

                view.findNavController()
                    .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeListFragment())
            }
        }

        binding.cancelBtn.setOnClickListener {view : View ->

            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeListFragment())

            binding.shoeNameEt.setText("")
            binding.shoeSizeEt.setText("")
            binding.companyNameEt.setText("")
            binding.shoeDescEt.setText("")


        }

        return binding.root
    }


}