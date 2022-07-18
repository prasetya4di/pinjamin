package com.project.pinjamin.ui.loaner.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.databinding.ItemLoanerBinding

class ItemLoanerAdapter(
    private val loaners: List<Borrower>,
    private val itemLoanerAdapterCallback: ItemLoanerAdapterCallback
) : RecyclerView.Adapter<ItemLoanerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemLoanerAdapter.ViewHolder =
        ViewHolder(ItemLoanerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemLoanerAdapter.ViewHolder, position: Int) {
        val loaner = loaners[position]
        holder.binding.tvName.text = loaner.nama
        holder.binding.tvPhoneNumber.text = loaner.noHp
        holder.binding.tvAddress.text = loaner.alamat
        holder.binding.tvDivision.text = loaner.divisi
        holder.binding.btnEdit.setOnClickListener { itemLoanerAdapterCallback.tapEdit(loaner) }
        holder.binding.btnDelete.setOnClickListener { itemLoanerAdapterCallback.tapDelete(loaner) }
    }

    override fun getItemCount(): Int = loaners.size

    inner class ViewHolder(var binding: ItemLoanerBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemLoanerAdapterCallback {
        fun tapDelete(borrower: Borrower)
        fun tapEdit(borrower: Borrower)
    }
}
