package com.chahye.counterappkt

import android.app.Activity
import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>() // 코틀린 확장함수 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count_text_view.text = "${viewModel.count}"

        add_button.setOnClickListener {
            viewModel.count++
            count_text_view.text = "${viewModel.count}"
        }

        sub_button.setOnClickListener {
            viewModel.count--
            count_text_view.text = "${viewModel.count}"
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

    // 시스템에 의한 종료 시 UI 상태 유지
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", viewModel.count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.count = savedInstanceState.getInt("count")
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}