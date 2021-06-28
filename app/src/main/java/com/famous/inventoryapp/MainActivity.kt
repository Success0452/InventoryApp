package com.famous.inventoryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.famous.inventoryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addInvent.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }

        binding.viewInvent.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
        }

        binding.deleteInvent.setOnClickListener {
            startActivity(Intent(this, DeleteActivity::class.java))
        }

        binding.editInvent.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }
}