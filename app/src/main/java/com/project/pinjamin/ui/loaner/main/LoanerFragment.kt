package com.project.pinjamin.ui.loaner.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.pinjamin.R

class LoanerFragment : Fragment() {

    companion object {
        fun newInstance() = LoanerFragment()
    }

    private lateinit var viewModel: LoanerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loaner, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoanerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
