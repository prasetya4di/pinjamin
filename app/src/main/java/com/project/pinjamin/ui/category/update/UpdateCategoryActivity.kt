package com.project.pinjamin.ui.category.update

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateCategoryBinding
    private val viewModel: UpdateCategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = intent
        val idCategory = intent.getIntExtra("id_category", 0)
        viewModel.getCategory(idCategory)
        viewModel.category.observeForever { category ->
            category?.let {
                binding.etCategoryName.setText(category.nama)
                binding.btnReset.setOnClickListener { binding.etCategoryName.setText(category.nama) }
            }
        }
        binding.btnSave.setOnClickListener {
            if (binding.etCategoryName.text.isNullOrEmpty()) {
                Toast.makeText(this, "Nama Kategori tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.update(binding.etCategoryName.text.toString())
                onBackPressed()
            }
        }
    }
}
