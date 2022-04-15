package com.kofar.appuk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {
    // declare the GoogleSignInClient
    lateinit var mGoogleSignInClient: GoogleSignInClient

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    companion object {
        const val EXTRA_NAMA = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()

        val nama = intent.getStringExtra(EXTRA_NAMA)
        findViewById<TextView>(R.id.welcome_text).text = "$nama"

        // call requestIdToken as follows
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        findViewById<Button>(R.id.button_logout_welcome).setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            findViewById<TextView>(R.id.welcome_text).setText(personName)
        }
    }
}