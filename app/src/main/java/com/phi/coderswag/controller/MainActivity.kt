package com.phi.coderswag.controller

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.phi.coderswag.R
import com.phi.coderswag.adapter.CategoryAdapter
import com.phi.coderswag.databinding.ActivityMainBinding
import com.phi.coderswag.model.Category
import com.phi.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryAdapter(this, DataService.categories)
        binding.categoryListview.adapter = adapter

    }
}