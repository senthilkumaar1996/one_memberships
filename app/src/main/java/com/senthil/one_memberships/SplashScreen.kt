package com.senthil.one_memberships

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
           finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 3000) // 3 seconds toast duration.
    }

}