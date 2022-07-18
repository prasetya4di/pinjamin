package com.project.pinjamin.ui.loaner.update

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.R
import com.project.pinjamin.databinding.ActivityUpdateLoanerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateLoanerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateLoanerBinding
    private val viewModel: UpdateLoanerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateLoanerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idLoaner = intent.getIntExtra("id_loaner", 0)
        viewModel.get(idLoaner)
        viewModel.borrower.observeForever { borrower ->
            borrower?.let {
                binding.etName.setText(borrower.nama)
                binding.etAddress.setText(borrower.alamat)
                binding.etPhoneNumber.setText(borrower.noHp)
                binding.spinnerDivision.setSelection(
                    this.resources.getStringArray(R.array.list_division).indexOfFirst {
                        it == borrower.divisi
                    }
                )
                binding.btnReset.setOnClickListener {
                    binding.etName.setText(borrower.nama)
                    binding.etAddress.setText(borrower.alamat)
                    binding.etPhoneNumber.setText(borrower.noHp)
                    binding.spinnerDivision.setSelection(
                        this.resources.getStringArray(R.array.list_division).indexOfFirst {
                            it == borrower.divisi
                        }
                    )
                }
            }
        }
        binding.btnSave.setOnClickListener {
            if (
                binding.etName.text.isNullOrEmpty()
                || binding.etAddress.text.isNullOrEmpty()
                || binding.etPhoneNumber.text.isNullOrEmpty()
            ) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.update(
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
