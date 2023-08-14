package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.sharedviewmodelShoeListAndShoeDetail.ShoeListViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    // Access the ViewModel with the viewModels delegate
    private lateinit var shoeViewModel: ShoeListViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setSupportActionBar(binding.toolbar)



        // Obtain the NavController from the NavHostFragment
        navController = findNavController(R.id.myNavHostFragment)

        Timber.plant(Timber.DebugTree())


        // Set up the AppBarConfiguration with top-level destinations
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.loginFragment,
            // Add more top-level destinations here
        ))

        // Get the shared shoeViewModel using ViewModelProvider with activity context
        shoeViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        // You can now use the shoeViewModel to access and modify
        // the list of shoes
        val shoes = shoeViewModel.shoeData.value

        // Add new shoes, modify the list, etc.

        // Set up ActionBar with the NavController and AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
