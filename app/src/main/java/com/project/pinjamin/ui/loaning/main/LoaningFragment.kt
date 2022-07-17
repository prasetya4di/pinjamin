package com.project.pinjamin.ui.loaning.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.pinjamin.R

class LoaningFragment : Fragment() {

    companion object {
        fun newInstance() = LoaningFragment()
    }

    private lateinit var viewModel: LoaningViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loaning, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoaningViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
