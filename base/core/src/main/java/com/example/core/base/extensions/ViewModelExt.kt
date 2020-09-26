package com.example.core.base.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

fun ViewModel.io(codeBlock: () -> Unit) {
    viewModelScope.io(codeBlock)
}