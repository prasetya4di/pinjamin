package com.project.pinjamin.ui.loaning.create

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexboxLayoutManager
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.ActivityCreateLoaningBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateLoaningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateLoaningBinding
    private val viewModel: CreateLoaningViewModel by viewModels()
    private var userIsInteracting = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateLoaningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = FlexboxLayoutManager(this)
        val anotherLayoutManager = FlexboxLayoutManager(this)
        binding.rvSelectedItem.layoutManager = layoutManager
        binding.rvAvailableItem.layoutManager = anotherLayoutManager
        viewModel.categories.observeForever { categories ->
            categories?.let {
                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerCategory.adapter = spinnerAdapter
                binding.spinnerCategory.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            position: Int,
                            p3: Long
                        ) {
                            viewModel.changeCategory(categories[position])
                            userIsInteracting = false
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }
                    }
                binding.spinnerCategory.adapter = spinnerAdapter
            }
        }
        viewModel.categoryWithItems.observeForever { categoryWithItems ->
            categoryWithItems?.let {
                val adapter = AvailableItemAdapter(
                    it.items,
                    object : AvailableItemAdapter.AvailableItemAdapterCallback {
                        override fun onClick(item: Item) {
                            viewModel.selectItem(item)
                        }
                    }
                )
                binding.rvAvailableItem.adapter = adapter
            }
        }
        viewModel.borrowers.observeForever { borrowers ->
            borrowers?.let {
                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, borrowers)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerLoaner.adapter = spinnerAdapter
                binding.spinnerLoaner.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            position: Int,
                            p3: Long
                        ) {
                            viewModel.changeBorrower(borrowers[position])
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }
                    }
                binding.spinnerLoaner.adapter = spinnerAdapter
            }
        }
        viewModel.selectedItems.observeForever {
            val selectedItemAdapter = SelectedItemAdapter(
                it,
                object : SelectedItemAdapter.SelectedItemAdapterCallback {
                    override fun onClick(item: Item) {
                        viewModel.removeItem(item)
                        userIsInteracting = false
                    }
                })
            binding.rvSelectedItem.adapter = selectedItemAdapter
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        userIsInteracting = true
    }
}
