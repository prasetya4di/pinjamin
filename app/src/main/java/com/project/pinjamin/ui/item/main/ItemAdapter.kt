package com.project.pinjamin.ui.item.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.ItemInventoryBinding

class ItemAdapter(
    private val items: List<Item>,
    private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder =
        ViewHolder(ItemInventoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvItemNama.text = item.nama
        holder.binding.tvItemDesc.text = item.deskripsi
        holder.binding.tvItemStock.text = "Jumlah: ${item.stok}"
        holder.binding.btnEdit.setOnClickListener { itemAdapterCallback.tapEdit(item) }
        holder.binding.btnDelete.setOnClickListener { itemAdapterCallback.tapDelete(item) }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ItemInventoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface ItemAdapterCallback {
        fun tapDelete(item: Item)
        fun tapEdit(item: Item)
    }
}
