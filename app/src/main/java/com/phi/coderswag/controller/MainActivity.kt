package com.phi.coderswag.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.phi.coderswag.adapter.CategoryRecycleAdapter
import com.phi.coderswag.databinding.ActivityMainBinding
import com.phi.coderswag.services.DataService
import com.phi.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val intent = Intent(this@MainActivity, ProductsActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(intent)
        }

        binding.categoryListview.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.categoryListview.layoutManager = layoutManager
        binding.categoryListview.setHasFixedSize(true)
    }
}