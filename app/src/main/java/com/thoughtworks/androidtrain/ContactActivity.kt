package com.thoughtworks.androidtrain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.thoughtworks.androidtrain.data.Phone

const val KEY = "key"

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    fun ReturnActivityResult(view: View) {
        val intent = Intent()
        val a = Phone("123","456")
        intent.putExtra(KEY,a)
        setResult(2,intent)
        finish()
    }
}