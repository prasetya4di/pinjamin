package com.project.pinjamin.ui.loaning.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityCreateLoaningBinding

class CreateLoaningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateLoaningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateLoaningBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
