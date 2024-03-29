package com.example.authication

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

object GoogleSignInSingleton {
    private var googleSignInClient: GoogleSignInClient? = null

    fun getGoogleSignInClient(activity: AppCompatActivity): GoogleSignInClient {
        if (googleSignInClient == null) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("953033487537-bhmh3saasu5jj2o5i6i6fjelmcl0h4dm.apps.googleusercontent.com")
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(activity, gso)
        }
        return googleSignInClient!!
    }
}