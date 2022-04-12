package com.thoughtworks.androidtrain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        Log.i("MainActivity","start")
    }

    fun goNextActivity(view: View) {
        val intent = Intent(this, HelloActivity::class.java).apply {}
        startActivity(intent)
    }
}