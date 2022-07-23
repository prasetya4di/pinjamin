package com.project.pinjamin.ui.loaning.update

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexboxLayoutManager
import com.project.pinjamin.R
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.ActivityUpdateLoaningBinding
import com.project.pinjamin.ui.loaning.create.AvailableItemAdapter
import com.project.pinjamin.util.DateUtil
import com.project.pinjamin.util.dateToString
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateLoaningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateLoaningBinding
    private val viewModel: UpdateLoaningViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateLoaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idLoaning = intent.getIntExtra("id_loaning", 0)
        viewModel.getLoaningWithDetails(idLoaning)
        val layoutManager = FlexboxLayoutManager(this)
        binding.rvSelectedItem.layoutManager = layoutManager
        viewModel.loaningWithDetails.observeForever { loaningWithDetails ->
            loaningWithDetails?.let {
                binding.etLoaner.setText(it.borrower.nama)
                binding.etBorrowDate.setText(it.loaning.tglPeminjaman.dateToString("dd MMMM yyyy"))
                val listItem = it.loaningDetail.map { it.item }
                val adapter = AvailableItemAdapter(
                    listItem,
                    object : AvailableItemAdapter.AvailableItemAdapterCallback {
                        override fun onClick(item: Item) {
                            // Do Nothing
                        }
                    }
                )
                binding.rvSelectedItem.adapter = adapter
            }
        }
        binding.etReturnDate.setOnClickListener { pickReturnDate() }
        binding.btnSave.setOnClickListener {
            if (binding.etReturnDate.text.isNullOrEmpty()) {
                Toast.makeText(this, "Mohon pilih tanggal pengembalian", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.update()
                onBackPressed()
            }
        }
    }

    private fun pickReturnDate() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val date = formatter.parse("$year-${month + 1}-$dayOfMonth")
            date?.let { viewModel.updateReturnDate(it) }
            binding.etReturnDate.setText(
                getString(
                    R.string.tanggal_text,
                    dayOfMonth,
                    DateUtil.getMonthName(month),
                    year
                )
            )
        }, currentYear, currentMonth, currentDay)
        val loaning = viewModel.loaningWithDetails.value?.loaning
        loaning?.let {
            datePickerDialog.datePicker.minDate = it.tglPeminjaman.time
        }

        datePickerDialog.show()
    }
}
