package com.project.pinjamin.ui.item.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityCreateItemBinding

class CreateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
