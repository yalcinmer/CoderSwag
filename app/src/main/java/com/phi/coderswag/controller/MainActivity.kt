package com.phi.coderswag.controller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.phi.coderswag.adapter.CategoryAdapter
import com.phi.coderswag.adapter.CategoryRecycleAdapter
import com.phi.coderswag.databinding.ActivityMainBinding
import com.phi.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryRecycleAdapter(this, DataService.categories)
        binding.categoryListview.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.categoryListview.layoutManager = layoutManager
        binding.categoryListview.setHasFixedSize(true)
    }
}