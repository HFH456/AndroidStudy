package com.thoughtworks.androidtrain

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_thread.*
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        buttonClick()
    }

    private fun buttonClick() {
        val mRunnable = Runnable {
            run {
                var i = 0
                do {
                    i += 1
                    button.setText(i)
                    Thread.sleep(1000)
                } while (i != 10)

//                button.setText(Thread.currentThread().name)
            }
        }

        button.setOnClickListener {
            thread {
                var i = 0
                do {
                    runOnUiThread(Runnable {
                        button.setText("等待中")
                    })
                    i += 1
                    Thread.sleep(1000)
                } while (i != 10)
                runOnUiThread(Runnable {
                    button.setText("等待完成")
                })
                println(Thread.currentThread().name)
            }
        }
    }
}

