package com.avdhesh.myapplication1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avdhesh.myapplication1.databinding.AdapterLayBinding

class AdapterList(data: List<MyMod>) : RecyclerView.Adapter<AdapterList.ListHolder>() {


    private var dataList: MutableList<MyMod> = data as MutableList<MyMod>
    private lateinit var binding: AdapterLayBinding

    inner class ListHolder(private val binding:AdapterLayBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pro: MyMod) {
            binding.textView.text = pro.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        binding = AdapterLayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun add(myMod: MyMod)
    {
        if(myMod.text.isNotEmpty()) {
            dataList.add(myMod)
            notifyDataSetChanged()
        }
    }

    fun delete(myMod: MyMod)
    {
        if(dataList.contains(myMod)) {
            dataList.remove(myMod)
            notifyDataSetChanged()
        }
    }

}