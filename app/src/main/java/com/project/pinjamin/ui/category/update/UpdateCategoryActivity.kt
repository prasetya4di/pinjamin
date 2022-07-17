package com.project.pinjamin.ui.category.update

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateCategoryBinding

class UpdateCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
