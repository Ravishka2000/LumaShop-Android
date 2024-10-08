package com.android.lumashop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.lumashop.R
import com.android.lumashop.fragments.loginRegister.IntroductionFragment
import android.os.Handler
import android.os.Looper

class LoginRegisterActivity : AppCompatActivity() {

    private var isReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition { !isReady }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, IntroductionFragment())
                .commit()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            isReady = true
        }, 0)
    }
}
