package com.example.digitalhousefoods.domain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.digitalhousefoods.R
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity(), FoodsAdapter.OnClickFoodsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val fragInformation = InformationRestaurantFrangment.newInstance()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_restaurant, fragInformation)
        }
    }

    override fun onClickFoods(position: Int) {
    }
}