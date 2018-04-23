package com.felix.test.exp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_retrun_exception.*

class ReturnExceptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrun_exception)

        ret1.setOnClickListener {
            Log.e("doRet1", testExp1().toString())
        }
        ret2.setOnClickListener {
            Log.e("doRet2", testExp2().toString())
        }

        ret3.setOnClickListener {
            Log.e("doRet3", testExp3().toString())
        }

        ret4.setOnClickListener {

        }

    }

    private fun testExp3(): Int {
        var c = 1
        try {
            c +=10
            Log.e("try", "c = $c")
            return c
        } catch (e: Exception) {
            c+=100
            e.printStackTrace()
        } finally {
            c+=1000
            Log.e("finally", "c = $c")
        }
        return 10000
    }

    private fun testExp2(): Int {
        var c = 1
        try {
            return c++
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return c
        }
    }



    private fun testExp1(): Int {
        var c = 1
        try {
            return c+1
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return c
        }
    }
}
