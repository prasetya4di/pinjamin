package com.project.pinjamin.ui.item.update

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateItemBinding

class UpdateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
