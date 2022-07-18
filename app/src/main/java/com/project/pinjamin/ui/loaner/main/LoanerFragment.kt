package com.project.pinjamin.ui.loaner.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.pinjamin.R
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.databinding.FragmentLoanerBinding
import com.project.pinjamin.ui.loaner.create.CreateLoanerActivity
import com.project.pinjamin.ui.loaner.update.UpdateLoanerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoanerFragment : Fragment() {

    private var _binding: FragmentLoanerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoanerBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val layoutManager = LinearLayoutManager(this.context)
        val loanerViewModel = ViewModelProvider(this)[LoanerViewModel::class.java]
        binding.rvLoaner.layoutManager = layoutManager
        binding.fabAddLoaner.setOnClickListener {
            startActivity(Intent(this.context, CreateLoanerActivity::class.java))
        }
        loanerViewModel.borrowers.observeForever {
            val itemLoanerAdapter = ItemLoanerAdapter(
                it,
                object : ItemLoanerAdapter.ItemLoanerAdapterCallback {
                    override fun tapDelete(borrower: Borrower) {
                        this@LoanerFragment.context?.let { it1 ->
                            AlertDialog.Builder(it1)
                                .setTitle("Konfirmasi Hapus")
                                .setMessage("Apakah anda yakin akan menghapus data ${borrower.nama} ??")
                                .setIcon(R.drawable.ic_delete)
                                .setPositiveButton("YES") { _, _ ->
                                    loanerViewModel.delete(
                                        borrower
                                    )
                                }
                                .setNegativeButton("NO") { _, _ -> }
                                .show()
                        }
                    }

                    override fun tapEdit(borrower: Borrower) {
                        val intent =
                            Intent(this@LoanerFragment.context, UpdateLoanerActivity::class.java)
                        intent.putExtra("id_loaner", borrower.idPeminjam)
                        startActivity(intent)
                    }
                }
            )
            binding.rvLoaner.adapter = itemLoanerAdapter
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
