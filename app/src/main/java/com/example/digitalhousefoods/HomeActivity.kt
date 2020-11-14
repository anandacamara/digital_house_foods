package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhousefoods.domain.Restaurant
import com.example.digitalhousefoods.domain.RestaurantAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RestaurantAdapter.OnClickRestaurantListener {
    val listRestaurant = getRestaurants()
    val adapter = RestaurantAdapter(listRestaurant, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_restaurants.adapter = adapter
        rv_restaurants.layoutManager = LinearLayoutManager(this)
        rv_restaurants.setHasFixedSize(true)


    }

    fun getRestaurants(): ArrayList<Restaurant>{
        return arrayListOf(Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, SP", "22:00", R.drawable.image1),
            Restaurant("Aoyama - Moema", "Alameda do Arapanés, 532 - Moema", "00:00", R.drawable.image4),
            Restaurant("Outback - Moema", "Av. Moacir, 187 - Moema", "00.00", R.drawable.image5),
            Restaurant("Sí Señor!", "Alameda Juaperi, 626 - Moema", "01:00", R.drawable.image3)
        )
    }

    override fun onClickRestaurant(position: Int) {
        val restaurant = listRestaurant.get(position)
        val intent = Intent(this, RestaurantActivity::class.java)
        intent.putExtra("codigo", restaurant.imageViewid)
        intent.putExtra("name", restaurant.name)
        startActivity(intent)
    }
}