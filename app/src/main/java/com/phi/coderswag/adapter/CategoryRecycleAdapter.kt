package com.phi.coderswag.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.phi.coderswag.R
import com.phi.coderswag.model.Category

class CategoryRecycleAdapter(private val context: Context, private val categories: List<Category>, private val itemClick: (Category) -> Unit) :
    RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)

    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        private val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        @SuppressLint("DiscouragedApi")
        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener{ itemClick(category) }
        }
    }
}