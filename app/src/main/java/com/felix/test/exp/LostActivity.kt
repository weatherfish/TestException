package com.felix.test.exp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lost.*

class LostActivity : AppCompatActivity() {

    private var runnable =  Runnable {
        while (true){
            Log.e("runnable begin"," isInterrupted--> "+Thread.currentThread().isInterrupted)
            try {
                Thread.sleep(15*1000)
            }catch (e:InterruptedException){
                Log.e("InterruptedException"," isInterrupted--> "+Thread.currentThread().isInterrupted)
                e.printStackTrace()
            }
            Log.e("runnable end"," isInterrupted--> "+Thread.currentThread().isInterrupted)
        }
    }
    private var thread:Thread = Thread(runnable)

    private var unblockingRunnable =  Runnable {
        while (true){
            Log.e("InterruptedException"," isInterrupted--> "+Thread.currentThread().isInterrupted)
        }
    }
    private var unblockingThread:Thread = Thread(unblockingRunnable)

    private var runnable2 =  Runnable {
        while (true){
            Log.e("runnable begin"," isInterrupted--> "+Thread.currentThread().isInterrupted)
            try {
                Thread.sleep(15*1000)
            }catch (e:InterruptedException){
                Log.e("before interrupt"," isInterrupted--> "+Thread.currentThread().isInterrupted)
                e.printStackTrace()
                Thread.currentThread().interrupt()
                Log.e("after interrupt"," isInterrupted--> "+Thread.currentThread().isInterrupted)
            }
            Log.e("runnable end"," isInterrupted--> "+Thread.currentThread().isInterrupted)
        }
    }
    private var thread2:Thread = Thread(runnable2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost)
        start.setOnClickListener{
            thread.start()
        }
        blockingInterrupt.setOnClickListener {
            thread.interrupt()
        }

        unblockingStart.setOnClickListener{
            unblockingThread.start()
        }

        unblockingInterrupt.setOnClickListener {
            unblockingThread.interrupt()
        }

        start2.setOnClickListener{
            thread2.start()
        }
        blockingInterrupt2.setOnClickListener {
            thread2.interrupt()
        }
    }
}
