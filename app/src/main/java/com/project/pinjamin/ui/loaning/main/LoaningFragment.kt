package com.project.pinjamin.ui.loaning.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.databinding.FragmentLoaningBinding
import com.project.pinjamin.ui.loaning.create.CreateLoaningActivity
import com.project.pinjamin.ui.loaning.update.UpdateLoaningActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoaningFragment : Fragment() {
    private var _binding: FragmentLoaningBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoaningBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val layoutManager = LinearLayoutManager(this.context)
        val loaningViewModel = ViewModelProvider(this)[LoaningViewModel::class.java]
        binding.rvLoaning.layoutManager = layoutManager
        binding.fabAddLoaning.setOnClickListener {
            startActivity(
                Intent(
                    this.context,
                    CreateLoaningActivity::class.java
                )
            )
        }
        loaningViewModel.loanings.observeForever {
            val adapter = LoaningAdapter(
                it,
                object : LoaningAdapter.LoaningAdapterCallback {
                    override fun tapReturn(loaningWithDetails: LoaningWithDetails) {
                        val intent =
                            Intent(this@LoaningFragment.context, UpdateLoaningActivity::class.java)
                        intent.putExtra("id_loaning", loaningWithDetails.loaning.idPeminjaman)
                        startActivity(intent)
                    }
                }
            )
            binding.rvLoaning.adapter = adapter
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
