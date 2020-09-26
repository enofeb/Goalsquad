package com.example.core.base.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

fun ViewModel.io(codeBlock: suspend CoroutineScope.() -> Unit) {
    viewModelScope.io(codeBlock)
}