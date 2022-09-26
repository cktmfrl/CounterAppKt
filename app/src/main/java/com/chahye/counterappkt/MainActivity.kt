package com.chahye.counterappkt

import android.app.Activity
import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count_text_view.text = "$count"

        add_button.setOnClickListener {
            count++
            count_text_view.text = "$count"
        }

        sub_button.setOnClickListener {
            count--
            count_text_view.text = "$count"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            registerActivityLifecycleCallbacks(object: Application
            .ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    Log.d(TAG, "onActivityCreated: ")
                }

                override fun onActivityStarted(activity: Activity) {
                    Log.d(TAG, "onActivityStarted: ")
                }

                override fun onActivityResumed(activity: Activity) {
                    Log.d(TAG, "onActivityResumed: ")
                }

                override fun onActivityPaused(activity: Activity) {
                    Log.d(TAG, "onActivityPaused: ")
                }

                override fun onActivityStopped(activity: Activity) {
                    Log.d(TAG, "onActivityStopped: ")
                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                    Log.d(TAG, "onActivitySaveInstanceState: ")
                }

                override fun onActivityDestroyed(activity: Activity) {
                    Log.d(TAG, "onActivityDestroyed: ")
                }

            })
        }


    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}