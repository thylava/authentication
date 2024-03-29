package com.example.authication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object FirebaseAuthSingleton {
    lateinit var firebaseAuth: FirebaseAuth
}