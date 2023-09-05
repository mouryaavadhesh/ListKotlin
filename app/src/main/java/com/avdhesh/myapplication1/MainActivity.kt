package com.avdhesh.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.avdhesh.myapplication1.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private var listItem: List<MyMod> = ArrayList()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val layoutM = LinearLayoutManager(this@MainActivity)
        val recyclerView = binding.recycleView
        val editTextText = binding.editTextText
        recyclerView.layoutManager = layoutM
        val adapterList = AdapterList(listItem)
        recyclerView.adapter = adapterList
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.addBtn.setOnClickListener {
            if(editTextText.text.isNotEmpty()) {
                val mod = MyMod(text = editTextText.text.toString())
                adapterList.add(mod)
            }
        }

        binding.delBtn.setOnClickListener {
            if(editTextText.text.isNotEmpty()) {
                val mod = MyMod(text = editTextText.text.toString())
                adapterList.delete(mod)
            }
        }

    }
}