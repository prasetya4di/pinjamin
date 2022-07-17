package com.project.pinjamin.ui.loaning.update

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateLoaningBinding

class UpdateLoaningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateLoaningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateLoaningBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
