package com.harsh.assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.assignment.databinding.ActivityProfileBinding
import com.harsh.assignment.firebaseClient.FirebaseClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileBinding
    @Inject
    lateinit var firebaseClient: FirebaseClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tvProfileUsername.text = firebaseClient.currentUsername
            btnLocation.setOnClickListener {
                val intent = Intent(this@ProfileActivity, LocationActivity::class.java)
                startActivity(intent)
            }
        }

    }
}