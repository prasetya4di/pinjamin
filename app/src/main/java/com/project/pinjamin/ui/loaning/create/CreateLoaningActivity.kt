package com.project.pinjamin.ui.loaning.create

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexboxLayoutManager
import com.project.pinjamin.R
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.ActivityCreateLoaningBinding
import com.project.pinjamin.util.DateUtil
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class CreateLoaningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateLoaningBinding
    private val viewModel: CreateLoaningViewModel by viewModels()

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
                    }
                })
            binding.rvSelectedItem.adapter = selectedItemAdapter
        }

        binding.etBorrowDate.setOnClickListener {
            pickDate()
        }

        binding.btnReset.setOnClickListener {
            binding.etBorrowDate.text.clear()
            binding.spinnerLoaner.setSelection(0)
            binding.spinnerCategory.setSelection(0)
        }

        binding.btnSave.setOnClickListener {
            if (viewModel.isReadySubmit()) {
                viewModel.addLoaning()
                onBackPressed()
            }
        }
    }

    private fun pickDate() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val date = formatter.parse("$year-${month + 1}-$dayOfMonth")
            date?.let { viewModel.changeDate(it) }
            binding.etBorrowDate.setText(
                getString(
                    R.string.tanggal_text,
                    dayOfMonth,
                    DateUtil.getMonthName(month),
                    year
                )
            )
        }, currentYear, currentMonth, currentDay)
        datePickerDialog.show()
    }
}
