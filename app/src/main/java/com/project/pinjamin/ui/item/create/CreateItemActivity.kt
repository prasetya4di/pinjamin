package com.project.pinjamin.ui.item.create

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityCreateItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateItemBinding
    private val createItemViewModel: CreateItemViewModel by viewModels()
    private var isCategorySelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createItemViewModel.category.observeForever { categories ->
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
                            isCategorySelected = true
                            createItemViewModel.changeCategory(categories[position])
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            isCategorySelected = false
                        }
                    }
            }
        }
        binding.btnReset.setOnClickListener {
            binding.etItemName.text.clear()
            binding.etStok.text.clear()
            binding.etDescription.text.clear()
        }
        binding.btnSave.setOnClickListener {
            if (binding.etItemName.text.isNullOrEmpty()
                || binding.etStok.text.isNullOrEmpty()
                || binding.etDescription.text.isNullOrEmpty()
                || !isCategorySelected
            ) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else {
                createItemViewModel.insert(
                    binding.etItemName.text.toString(),
                    binding.etStok.text.toString(),
                    binding.etDescription.text.toString()
                )
                onBackPressed()
            }
        }
    }
}
