package com.genarossi19.suboscan


import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


import com.genarossi19.suboscan.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanFrontal.setOnClickListener {}
        binding.btnScan.setOnClickListener { navigateToScan() }
    }


    private fun navigateToScan(){
        val intent = Intent(this, ScanActivity::class.java)
        startActivity(intent)
    }


}
