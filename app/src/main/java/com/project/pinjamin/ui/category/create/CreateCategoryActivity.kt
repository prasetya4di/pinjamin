package com.project.pinjamin.ui.category.create

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityCreateCategoryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCategoryBinding
    private val viewModel: CreateCategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener { binding.etCategoryName.text.clear() }
        binding.btnSave.setOnClickListener {
            if (binding.etCategoryName.text.isNullOrEmpty()) {
                Toast.makeText(this, "Nama Kategori tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertCategory(binding.etCategoryName.text.toString())
                onBackPressed()
            }
        }
    }
}
