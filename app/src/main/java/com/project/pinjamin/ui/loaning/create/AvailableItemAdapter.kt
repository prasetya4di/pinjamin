package com.project.pinjamin.ui.loaning.create

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.AvailableLoanItemBinding

class AvailableItemAdapter(
    private val availableItems: List<Item>,
    private val availableItemAdapterCallback: AvailableItemAdapterCallback
) : RecyclerView.Adapter<AvailableItemAdapter.ViewHolder>() {
    interface AvailableItemAdapterCallback {
        fun onClick(item: Item)
    }

    inner class ViewHolder(var binding: AvailableLoanItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AvailableItemAdapter.ViewHolder =
        ViewHolder(
            AvailableLoanItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AvailableItemAdapter.ViewHolder, position: Int) {
        val item = availableItems[position]
        holder.binding.tvSelectedItem.text = item.nama
        holder.binding.cardAvailableItem.setOnClickListener {
            availableItemAdapterCallback.onClick(
                item
            )
        }
    }

    override fun getItemCount(): Int = availableItems.size
}
