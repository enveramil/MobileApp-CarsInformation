package com.enveramil.carsinformation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enveramil.carsinformation.Singleton.singleton
import com.enveramil.carsinformation.databinding.RecyclerRowBinding

class CarsAdapter(val carsList : ArrayList<CarsModel>) : RecyclerView.Adapter<CarsAdapter.CarsHolder>() {

    class CarsHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        // Oluşturulan layout ile bağlama işlemi yapılmaktadır.
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarsHolder(binding)
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        // Layout bağlandıktan sonra neler olacağını bu fonksiyon içerisinde belirtiriz.
        holder.binding.carsRecyclerView.text = carsList.get(position).carName
        holder.binding.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context,InformationPage::class.java)
            //intent.putExtra("cars",carsList.get(position))
            //chosenCarsList = carsList.get(position)
            Singleton.singleton = carsList.get(position)
            holder.itemView.context.startActivity(intent)
        }
        // Her bir item'a tıklanınca başka sayfaya gidecek



    }

    override fun getItemCount(): Int {
        // Kaç tane oluşturacağımızı burada belirtiriz.
        return carsList.size
    }

    fun deleteItem(position : Int){
        carsList.removeAt(position)
        notifyItemRemoved(position)

    }



}