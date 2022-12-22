package com.education.homework3.firebase.sign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.education.homework3.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.sign_in_activity, SignInFragment.newInstance())
                .commitNow()
        }
    }

}