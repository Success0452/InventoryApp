package com.famous.inventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.famous.inventoryapp.databinding.ActivityAddBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Users")

        binding.saveBtn.setOnClickListener {
            sendData()
        }


    }

    private fun sendData() {
        val name = binding.name.text.toString().trim()
        val email = binding.email.text.toString().trim()

        if (name.isNotEmpty() && email.isNotEmpty() )
        {
            var model = DatabaseModel(name,email)
            var id = reference.push().key

            //Set Data To Firebase
            reference.child(id!!).setValue(model)

            binding.email.setText("")
            binding.name.setText("")
        }else
        {
            Toast.makeText(this, "All field are required", Toast.LENGTH_SHORT).show()
        }
    }
}