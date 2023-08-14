package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.sharedviewmodelShoeListAndShoeDetail.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {


    // Access the same ViewModel instance as the activity
    private val viewModel: ShoeListViewModel by activityViewModels()

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        registerForContextMenu(view)
//    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding : FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        Log.i("ShoeListFragment", "called viewmodelprovider")
       // You don't need to manually create the ViewModel, just
        // use viewModel
       // Now you can use the viewModel directly to access the
        // list of shoes or other ViewModel functions

        // viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)



        // Set up the custom adapter for the ListView using data binding
       // val adapter = ShoeDataAdapter(requireContext(), mutableListOf())
       // binding.shoesLv.adapter = adapter

        // Observe the LiveData in the Fragment
        viewModel.shoeData.observe(viewLifecycleOwner) { shoeDataList ->
            // Update the adapter when LiveData changes
            //  adapter.clear()
            //  adapter.addAll(shoeDataList)
            //  adapter.notifyDataSetChanged()

            if (!shoeDataList.isNullOrEmpty()) {
                shoeDataList.forEach { shoe ->
                    val shoeItem = ShoeItem(context)
                    shoeItem.setProduct(
                        shoe.images[0],
                        shoe.images[1],
                        shoe.name,
                        shoe.company,
                        shoe.size,
                        shoe.description
                    )

                    val myLayout: LinearLayout = binding.shoesListContainer

                    shoeItem.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    myLayout.addView(shoeItem)
                }

            }
        }

        binding.addFab.setOnClickListener { view : View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetails())
        }


        // Hide the MainActivity's ActionBar (toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()


        binding.toolbarShoelist.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.loginFragment -> {
                    val navController = requireView().findNavController()
                    navController.navigate(R.id.loginFragment)
                    true
                }
                else -> false
            }
        }




        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }



//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || false //super.onOptionsItemSelected(item)
//    }
}