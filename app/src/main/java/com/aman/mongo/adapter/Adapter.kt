package com.aman.mongo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aman.mongo.databinding.ItemsBinding
import com.aman.mongo.model.Model

class Adapter(val data:List<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

         return ViewHolder(binding)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.binding.email.text = data[position].email
         holder.binding.name.text = data[position].name
     }

     override fun getItemCount() = data.size

    class ViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root)

}