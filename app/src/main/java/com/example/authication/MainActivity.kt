package com.example.authication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()


        binding.logout.setOnClickListener {
            // Sign out user
            auth.signOut()
            // Redirect to SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)

            // Finish current activity
            finish()

            // Redirect to login screen or perform other actions as needed
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        }
    }
}