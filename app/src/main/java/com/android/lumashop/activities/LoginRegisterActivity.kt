package com.android.lumashop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.lumashop.R
import com.android.lumashop.fragments.loginRegister.IntroductionFragment

class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        // Load the IntroductionFragment into the fragment_container
        if (savedInstanceState == null) { // Ensure the fragment is not reloaded on configuration changes
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, IntroductionFragment())
                .commit()
        }
    }
}
