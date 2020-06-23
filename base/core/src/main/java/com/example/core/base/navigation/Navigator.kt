package com.example.core.base.navigation

import android.content.Intent

const val PACKAGE_NAME = "com.example.goalsquad"

private fun intentTo(className: String) =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)

fun String.createIntentFeature() = try {
    Class.forName(this).run { intentTo(this@createIntentFeature) }
} catch (e: ClassNotFoundException) {
    null
}