package com.felix.test.exp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_vmerror.*

class VMErrorActivity : AppCompatActivity() {

    private var stackSize: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmerror)

        stackOverFlow.setOnClickListener {
            stackOverCall()
        }

        outOfMemory.setOnClickListener {
            var list = ArrayList<BigClass>()
            while (true){
                Log.e("----","--outOfMemory-- " + list.size)
                list.add(BigClass())
            }
        }

        threadOutOfMemory.setOnClickListener{
            while (true){
                val thread = Thread(Runnable { Thread.sleep(10*60*60) })
                thread.start()
            }
        }
    }

    private fun stackOverCall() {
        Log.e("----", "stackOverCall     $stackSize")
        stackSize++
        stackOverCall()
    }

}
