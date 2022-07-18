package com.project.pinjamin.ui.loaner.create

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.R
import com.project.pinjamin.databinding.ActivityCreateLoanerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateLoanerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateLoanerBinding
    private val viewModel: CreateLoanerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateLoanerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            binding.etName.text.clear()
            binding.etAddress.text.clear()
            binding.etPhoneNumber.text.clear()
            binding.spinnerDivision.setSelection(0)
        }
        binding.btnSave.setOnClickListener {
            if (
                binding.etName.text.isNullOrEmpty()
                || binding.etAddress.text.isNullOrEmpty()
                || binding.etPhoneNumber.text.isNullOrEmpty()
            ) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insert(
                    binding.etName.text.toString(),
                    binding.etPhoneNumber.text.toString(),
                    binding.etAddress.text.toString(),
                    this.resources.getStringArray(R.array.list_division)[binding.spinnerDivision.selectedItemPosition]
                )
                onBackPressed()
            }
        }
    }
}
