package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.digitalhousefoods.R
import kotlinx.android.synthetic.main.activity_foods.*

class FoodsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)

        var name = intent.getStringExtra("name")
        var information = intent.getStringExtra("information")
        var imageId = intent.getIntExtra("imageId", 0)

        name_food.text = name
        food_description.text = information
        image_food.setImageResource(imageId)

        val toolbar: Toolbar = findViewById(R.id.toolbar_food)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}