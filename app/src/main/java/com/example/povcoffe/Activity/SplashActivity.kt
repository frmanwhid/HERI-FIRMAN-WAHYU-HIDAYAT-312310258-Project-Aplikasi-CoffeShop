package com.example.povcoffe.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.povcoffe.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 2000 // 3 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Penting! Gunakan Handler dengan Looper.getMainLooper()
        Handler(Looper.getMainLooper()).postDelayed({
            // Pastikan package dan nama class sesuai dengan struktur project Anda
            val intent = Intent(this@SplashActivity, IntroActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity splash agar tidak bisa kembali ke sini
        }, SPLASH_TIMEOUT)
    }
}