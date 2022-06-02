package com.thoughtworks.androidtrain

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_thread.*
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        buttonClick()
    }

    private fun buttonClick() {

        button.setOnClickListener {
            val lock = ReentrantLock()

            button.isEnabled = false
            lock.lock()
            val countToTen = thread {
                var i = 0
                do {
                    runOnUiThread(Runnable {
                        button.setText(i.toString())
                    })
                    i += 1
                    Thread.sleep(500)
                } while (i != 10)
//                runOnUiThread(Runnable {
//                    button.setText("等待完成")
//                })
            }
            countToTen.join()
            button.isEnabled = true
        }
    }
}

