package com.example.findyourbeer

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Указываем XML-макет
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener { // так как мы создаем в ONCreate
            //слушатель начнет как можно быстрее реагировать на кнопку
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem
            val beerList=getBeers(color.toString())
            val beers = beerList.reduce {str, item -> str + '\n' + item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }
    }
    fun getBeers(color: String):List<String>{
        return when (color){
            "Light" -> listOf("Jail Pale Ale", "Lager Litle")
            "Amber" -> listOf("Jack Amber","Red Moose")
            "Brown" -> listOf("Brown Bear Beer","Bock Brownie")
            else -> listOf("Gout Stout","Dark Daniel")
        }
    }
}
