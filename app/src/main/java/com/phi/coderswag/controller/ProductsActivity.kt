package com.phi.coderswag.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.phi.coderswag.databinding.ActivityProductsBinding
import com.phi.coderswag.model.Category
import com.phi.coderswag.utilities.EXTRA_CATEGORY
import java.io.Serializable

@Suppress("DEPRECATION")
class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category: Serializable? = intent.getSerializableExtra(EXTRA_CATEGORY)
        println(category)
    }
}