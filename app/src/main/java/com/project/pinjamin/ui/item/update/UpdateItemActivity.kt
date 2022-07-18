package com.project.pinjamin.ui.item.update

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateItemBinding
    private val updateItemViewModel: UpdateItemViewModel by viewModels()
    private var isCategorySelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateItemViewModel.category.observeForever { categories ->
            categories?.let {
                val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, categories)
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
                            isCategorySelected = true
                            updateItemViewModel.changeCategory(categories[position])
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            isCategorySelected = false
                        }
                    }
            }
        }
        val idItem = intent.getIntExtra("id_item", 0)
        updateItemViewModel.getItem(idItem)
        updateItemViewModel.item.observeForever { item ->
            item?.let {
                binding.etItemName.setText(item.nama)
                binding.etStok.setText(item.stok.toString())
                binding.etDescription.setText(item.deskripsi ?: "")
                updateItemViewModel.category.let { categories ->
                    categories.value?.let { it1 ->
                        binding.spinnerCategory.setSelection(it1.indexOfFirst { category ->
                            category.idKategori == item.idKategori
                        })
                    }
                }
                binding.btnReset.setOnClickListener {
                    binding.etItemName.setText(item.nama)
                    binding.etStok.setText(item.stok.toString())
                    binding.etDescription.setText(item.deskripsi ?: "")
                }
            }
        }
        binding.btnSave.setOnClickListener {
            if (binding.etItemName.text.isNullOrEmpty()
                || binding.etStok.text.isNullOrEmpty()
                || binding.etDescription.text.isNullOrEmpty()
                || !isCategorySelected
            ) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else {
                updateItemViewModel.updateItem(
                    binding.etItemName.text.toString(),
                    binding.etStok.text.toString(),
                    binding.etDescription.text.toString()
                )
                onBackPressed()
            }
        }
    }
}
