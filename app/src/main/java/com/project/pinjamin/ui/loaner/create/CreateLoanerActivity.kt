package com.project.pinjamin.ui.loaner.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityCreateLoanerBinding

class CreateLoanerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateLoanerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateLoanerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
