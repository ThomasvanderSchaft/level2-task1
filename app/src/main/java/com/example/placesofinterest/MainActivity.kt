package com.example.placesofinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlaceAdapter
    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        viewAdapter = PlaceAdapter(places)
        //gets layout item and assigns it to variable
        recyclerView = findViewById(R.id.rvPlaces)
        //assigns the adapter items to the recyclerView
        recyclerView.adapter = viewAdapter
        //assigns a specific layout to the recycler view
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)

        //loops through all place names
        for (i in Place.PLACE_NAMES.indices) {
            //adds the name and picture of the place to the adapter
            places.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        //notifies adapter that there has been a change
        placeAdapter.notifyDataSetChanged()

    }
    private fun initViews(){
        //makes the recyclerView place items vertically
        rvPlaces.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
    }
}
