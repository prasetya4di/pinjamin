package com.project.pinjamin.ui.loaning.create

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.SelectedLoanItemBinding

class SelectedItemAdapter(
    private val selectedItems: List<Item>,
    private val selectedItemAdapterCallback: SelectedItemAdapterCallback
) : RecyclerView.Adapter<SelectedItemAdapter.ViewHolder>() {
    interface SelectedItemAdapterCallback {
        fun onClick(item: Item)
    }

    inner class ViewHolder(var binding: SelectedLoanItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectedItemAdapter.ViewHolder =
        ViewHolder(
            SelectedLoanItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SelectedItemAdapter.ViewHolder, position: Int) {
        val item = selectedItems[position]
        holder.binding.tvSelectedItem.text = item.nama
        holder.binding.cardSelectedItem.setOnClickListener {
            selectedItemAdapterCallback.onClick(
                item
            )
        }
    }

    override fun getItemCount(): Int = selectedItems.size
}
