package com.phi.coderswag.controller

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.phi.coderswag.adapter.ProductsAdapter
import com.phi.coderswag.databinding.ActivityProductsBinding
import com.phi.coderswag.services.DataService
import com.phi.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY).toString()

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)

        binding.productsListview.adapter = adapter
        binding.productsListview.layoutManager = layoutManager

    }
}