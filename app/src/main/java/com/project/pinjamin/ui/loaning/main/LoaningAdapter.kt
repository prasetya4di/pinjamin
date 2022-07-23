package com.project.pinjamin.ui.loaning.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.databinding.ItemLoaningBinding
import com.project.pinjamin.util.dateToString

class LoaningAdapter(
    private val listLoaning: List<LoaningWithDetails>,
    private val loaningAdapterCallback: LoaningAdapterCallback
) : RecyclerView.Adapter<LoaningAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoaningAdapter.ViewHolder =
        ViewHolder(ItemLoaningBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: LoaningAdapter.ViewHolder, position: Int) {
        val loaning = listLoaning[position].loaning
        val borrower = listLoaning[position].borrower
        val details = listLoaning[position].loaningDetail
        if (loaning.tglPengembalian == null) {
            holder.binding.btnReturnItem.visibility = View.VISIBLE
            holder.binding.btnDone.visibility = View.GONE
            holder.binding.btnReturnItem.setOnClickListener {
                loaningAdapterCallback.tapReturn(
                    listLoaning[position]
                )
            }
        }
        holder.binding.tvLoanerName.text = "Peminjam: ${borrower.nama}"
        holder.binding.tvDescription.text = "Deskripsi: ${loaning.status}"
        holder.binding.tvLoanDate.text =
            "Tanggal Pinjam: ${loaning.tglPeminjaman.dateToString("dd MMMM yyyy")}"
        holder.binding.tvReturnDate.text =
            "Tanggal Kembali: ${loaning.tglPengembalian?.dateToString("dd MMMM yyyy") ?: "--"}"
        holder.binding.tvBorrowedItems.text = "Barang: ${details.joinToString(",")}"
    }

    override fun getItemCount(): Int = listLoaning.size

    inner class ViewHolder(val binding: ItemLoaningBinding) : RecyclerView.ViewHolder(binding.root)

    interface LoaningAdapterCallback {
        fun tapReturn(loaningWithDetails: LoaningWithDetails)
    }
}
