package com.enveramil.carsinformation

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enveramil.carsinformation.databinding.ActivityMainBinding
import com.google.android.material.internal.ContextUtils.getActivity

//var chosenCarsList : CarsModel? = null

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var carsList : ArrayList<CarsModel>
    private lateinit var carsAdapter : CarsAdapter
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
        carsList.add(polo)
        carsList.add(golf)
        carsList.add(fr)
        carsList.add(m3)
        carsList.add(range)
        carsList.add(escalade)

        // Inefficient
        // Bitmap ile görsel boyutunu küçültebiliriz
        //val bitmap = BitmapFactory.decodeResource(resources,R.drawable.fr)

        binding.carsRecyclerView.layoutManager = LinearLayoutManager(this)
        carsAdapter = CarsAdapter(carsList)
        binding.carsRecyclerView.adapter = carsAdapter


        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(carsAdapter))
        itemTouchHelper.attachToRecyclerView(binding.carsRecyclerView)
        binding.emptyView.visibility = View.INVISIBLE
        binding.button.visibility = View.INVISIBLE

        carsAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver(){
            override fun onChanged() {
                super.onChanged()
                checkEmpty()
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                checkEmpty()
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                super.onItemRangeRemoved(positionStart, itemCount)
                checkEmpty()
            }
            fun checkEmpty(){

                if (carsAdapter.itemCount == 0){
                    binding.emptyView.visibility = View.VISIBLE
                    binding.button.visibility = View.VISIBLE
                }else{
                    binding.emptyView.visibility = View.GONE
                    binding.button.visibility = View.GONE
                }


            }
        })

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater : MenuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.get_all_data){
            var intent = intent
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}