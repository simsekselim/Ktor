package com.simsekselim.ktor.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simsekselim.ktor.R
import com.simsekselim.ktor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}