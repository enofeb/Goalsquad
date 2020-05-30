package com.example.core.base.navigation.feature

interface Feature<T> {
    val key: String?
    val dynamicStart: T?
}