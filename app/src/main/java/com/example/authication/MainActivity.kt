package com.example.authication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authication.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth
    lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("953033487537-bhmh3saasu5jj2o5i6i6fjelmcl0h4dm.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)


        binding.logout.setOnClickListener {
            // Sign out user
            auth.signOut()
            SignInActivity.firebaseAuth.signOut()
            SignInActivity.signOut()
            googleSignInClient.signOut()
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