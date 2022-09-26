package com.chahye.counterappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.chahye.counterappkt.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>() // 코틀린 확장함수 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // UI 갱신 -> DataBinding 적용
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        add_button.setOnClickListener {
            viewModel.increaseCount()
        }
    }

    // 시스템에 의한 종료 시 UI 상태 유지
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("count", viewModel.count)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        viewModel.count = savedInstanceState.getInt("count")
//    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}