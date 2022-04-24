package com.enveramil.carsinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enveramil.carsinformation.databinding.ActivityInformationPageBinding

class InformationPage : AppCompatActivity() {
    private lateinit var binding: ActivityInformationPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val intent = intent
        //val selectedCars = intent.getSerializableExtra("cars") as CarsModel

        val selectedCars = Singleton.singleton

        selectedCars?.let {
            binding.imageView.setImageResource(it.carImage)
            binding.carNameView.text = it.carName
            binding.carNameModelView.text = it.carModel
        }






    }
}