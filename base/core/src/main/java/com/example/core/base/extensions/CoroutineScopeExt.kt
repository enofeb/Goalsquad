package com.example.core.base.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun CoroutineScope.io(codeBlock: () -> Unit) {
    this.launch {
        withContext(Dispatchers.IO) {
            codeBlock()
        }
    }
}