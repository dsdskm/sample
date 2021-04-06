package com.taetae98.navigation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB: ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {
    protected val binding by lazy { DataBindingUtil.setContentView<VB>(this, layoutId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewDataBinding()
    }

    private fun onCreateViewDataBinding() {
        binding.lifecycleOwner = this
    }
}