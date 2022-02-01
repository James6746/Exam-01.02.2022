package com.example.exam01022022

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.OrientationEventListener
import android.view.View
import android.widget.Toast
import androidx.print.PrintHelper.ORIENTATION_LANDSCAPE
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var restaurantList: ArrayList<Restaurant>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RestaurantAdapter
    private lateinit var listener: RestaurantAdapter.Listener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listener = object : RestaurantAdapter.Listener {
            override fun onBottomReachedListener(position: Int) {
                Toast.makeText(applicationContext, "Loading data...", Toast.LENGTH_SHORT)
                    .show()
                refreshAdapter(restaurantList)



            }

        }

        if(resources.configuration.orientation != ORIENTATION_LANDSCAPE){
            initViewsForLandscape()
        } else {
            initViews()
        }


    }

    private fun refreshAdapter(list: ArrayList<Restaurant>){
        adapter = RestaurantAdapter(list, listener)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        restaurantList = ArrayList()
        createList()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 1)
        refreshAdapter(restaurantList)


    }

    private fun createList() {

        for (i in 0..19) {
            restaurantList.add(
                Restaurant(
                    "Musaffo",
                    R.drawable.restaurant2,
                    3.5f,
                    "Osh",
                    "Dimlama"
                )
            )
        }

    }

    private fun initViewsForLandscape() {
        restaurantList = ArrayList()
        createList()
        recyclerView = findViewById(R.id.recyclerView)
        adapter = RestaurantAdapter(restaurantList, listener)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 3)
        recyclerView.adapter = adapter

    }
}