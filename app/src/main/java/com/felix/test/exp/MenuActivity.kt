package com.felix.test.exp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sample_text.text = stringFromJNI()

        return_exception.setOnClickListener {
            startActivity(Intent(this@MenuActivity, ReturnExceptionActivity::class.java))
        }

        error.setOnClickListener {
            startActivity(Intent(this@MenuActivity, VMErrorActivity::class.java))
        }

        lost.setOnClickListener{
            startActivity(Intent(this@MenuActivity, LostActivity::class.java))
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
