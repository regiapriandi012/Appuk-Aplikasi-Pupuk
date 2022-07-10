package com.kofar.appuk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.kofar.appuk.listdata.ListDataArtikel
import com.kofar.appuk.listdata.ListDataPupuk

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if(acct != null) {
            val personName = acct.displayName
            findViewById<TextView>(R.id.nama_home).text = personName

        }

        findViewById<ImageView>(R.id.imageView12).setOnClickListener {
            val intent = Intent(this, ListDataArtikel::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<Button>(R.id.tombol_artikel_home).setOnClickListener {
            val intent = Intent(this, ListDataArtikel::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<ImageView>(R.id.imageView13).setOnClickListener {
            val intent = Intent(this, ListDataPupuk::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<Button>(R.id.tombol_belanja_pupuk_home).setOnClickListener {
            val intent = Intent(this, ListDataPupuk::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<Button>(R.id.tombol_akun_home).setOnClickListener {
            val intent = Intent(this, AkunActivity::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<Button>(R.id.tombol_keranjang_belanja_home).setOnClickListener {
            val intent = Intent(this, ListDataPupuk::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }

        findViewById<Button>(R.id.tombol_home_home).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }
    }
}