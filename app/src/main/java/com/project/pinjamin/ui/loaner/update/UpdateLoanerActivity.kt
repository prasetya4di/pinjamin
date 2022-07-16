package com.project.pinjamin.ui.loaner.update

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.pinjamin.databinding.ActivityUpdateLoanerBinding

class UpdateLoanerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateLoanerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateLoanerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
