package com.enveramil.carsinformation

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.enveramil.carsinformation.databinding.ActivityMainBinding

//var chosenCarsList : CarsModel? = null

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var carsList : ArrayList<CarsModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        carsList = ArrayList<CarsModel>()

        // Get data with static
        val polo = CarsModel("VW Polo","1.4 TSI HIGHLINE",R.drawable.polo)
        val golf = CarsModel("VW Golf", "1.5 TSI R LINE", R.drawable.golf)
        val fr = CarsModel("Seat LEON FR","1.5 TSI ECO",R.drawable.fr)
        val m3 = CarsModel("BMW M3","2.0D TURBO",R.drawable.m3)
        val range = CarsModel("Range Rover","3.0 AutoBiography", R.drawable.range)
        val escalade = CarsModel("Escalade","5.0T TURBO MAKİNA",R.drawable.escalade)

        // put inside list.
        carsList.add(polo)
        carsList.add(golf)
        carsList.add(fr)
        carsList.add(m3)
        carsList.add(range)
        carsList.add(escalade)

        // Inefficient
        // Bitmap ile görsel boyutunu küçültebiliriz
        //val bitmap = BitmapFactory.decodeResource(resources,R.drawable.fr)



        binding.carsRecyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        val carsAdapter = CarsAdapter(carsList)
        binding.carsRecyclerView.adapter = carsAdapter





        /*
        // Adapter : Layout & data connection process
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,carsList.map { carsModel -> carsModel.carName })
        binding.carsListView.adapter = adapter

        binding.carsListView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, InformationPage :: class.java)
            intent.putExtra("cars",carsList.get(i))
            startActivity(intent)
        }

         */

    }
}