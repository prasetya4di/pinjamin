package com.project.pinjamin.ui.category.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.databinding.ItemCategoryBinding

class ItemCategoryAdapter(
    private val categories: List<Category>,
    private val itemCategoryAdapterCallback: ItemCategoryAdapterCallback
) : RecyclerView.Adapter<ItemCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCategoryAdapter.ViewHolder =
        ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    inner class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ItemCategoryAdapter.ViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.tvItemNama.text = category.nama
        holder.binding.btnDelete.setOnClickListener { itemCategoryAdapterCallback.tapDelete(category) }
        holder.binding.btnEdit.setOnClickListener { itemCategoryAdapterCallback.tapEdit(category) }
    }

    override fun getItemCount(): Int = categories.size

    interface ItemCategoryAdapterCallback {
        fun tapDelete(category: Category)
        fun tapEdit(category: Category)
    }
}
