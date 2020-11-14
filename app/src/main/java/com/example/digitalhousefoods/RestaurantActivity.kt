package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.digitalhousefoods.domain.Foods
import com.example.digitalhousefoods.domain.FoodsAdapter
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity(),
    FoodsAdapter.OnClickFoodsListener {
    var listFoods = getFoods()
    val adapter =
        FoodsAdapter(listFoods, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        var codigoImageViewRestaurant = intent.getIntExtra("codigo", 0)
        var nameRestaurant = intent.getStringExtra("name")

        imageView_restaurant.setImageResource(codigoImageViewRestaurant)
        name_restaurant.text = nameRestaurant

        rv_restaurants_information.adapter = adapter
        rv_restaurants_information.layoutManager = GridLayoutManager(this, 2)
        rv_restaurants_information.setHasFixedSize(true)

        val toolbar: Toolbar = findViewById(R.id.toolbar_restaurant)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    fun getFoods(): ArrayList<Foods>{
        return arrayListOf(
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            ),
            Foods(
                R.drawable.image4,
                "Salada com molho gengibre",
                "É uma comida muito daora que tem folhas, tomate e grilo colocados de um jeito chique e molho de gengibre"
            )
        )
    }


    override fun onClickFoods(position: Int) {
        val food = listFoods.get(position)
        val intent = Intent(this, FoodsActivity::class.java)
        intent.putExtra("name", food.name)
        intent.putExtra("information", food.information)
        intent.putExtra("imageId", food.imageId)
        startActivity(intent)
    }
}