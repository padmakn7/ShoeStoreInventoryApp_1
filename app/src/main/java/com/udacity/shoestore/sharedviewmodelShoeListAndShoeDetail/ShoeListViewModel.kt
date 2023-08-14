package com.udacity.shoestore.sharedviewmodelShoeListAndShoeDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe


class ShoeListViewModel : ViewModel() {

    private val _shoeData = MutableLiveData<MutableList<Shoe>>()
    val shoeData: LiveData<MutableList<Shoe>>
        get() = _shoeData



    init{
        Log.i("ShoeListViewModel", "shoelistviewmodel created")
        _shoeData.value = mutableListOf(
            Shoe(
                name ="Women's Sneakers Athletic Sport Running Tennis Walking Shoes",
                size = 9.5,
                company = "TSIODFO",
                description = "Synthetic Rubber sole\n" +
                        "Comfortable and breathable fabric\n" +
                        "Non-slip Wear-resistant outsole\n" +
                        "Slip on design easy to wear, fashion colour with everything\n" +
                        "Multi-color choose: Red pink black navy blue yellow army green beige rose red white Fluorescent green\n" +
                        "Occasion: casual, walking, running,driving , training, indoor, sports, outdoor, travel, workout and so on.",
                images = mutableListOf(R.drawable.shoe_image_1_1, R.drawable.shoe_image_1_2)

            ),
            Shoe(
                name="Womens Slip on Walking Running Shoes Blade Tennis Casual Fashion Sneakers Comfort Non Slip Work Sport Athletic Trainer",
                size = 8.0,
                company = "Hetohec",
                description = "Rubber sole\n" +
                        "Memory Foam Insole: The memory foam insole is comfortable to touch,absorbs the impact force in motion, reduces the burden on the body.\n" +
                        "Lightweight,fashion knitted mesh upper for ultra-lightweight support and breathability can maximizes the upper surface,our running shoes let your foot always keeps dry and cool.\n" +
                        "Non-slip rubber Sole: Effectively reduce cushioning force and provide sufficient friction,let each step of your move all relaxed.\n" +
                        "The elastic blade soles have high flexibility,provide more the protection of the foot and knees.\n" +
                        "Suiting Occasions:Casual,Walking,Running,Travel,Athletic,Exercise,Gym,Tennis ,Outdoor,Travel,Exercise,Workout,Volleyball,Basketball，Jogging ，Bike，Racquetball and other outdoor sport.simple style, all-match colors.",
                images = mutableListOf(R.drawable.shoe_image_2_1, R.drawable.shoe_image_2_2)
            )
        )
    }

    // Function to add a new shoe
    fun addShoe(shoe: Shoe) {
        _shoeData.value?.add(shoe)
        // Notify observers about the change
        _shoeData.value = _shoeData.value
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel", "shoelistviewmodel destroyed")
    }
}