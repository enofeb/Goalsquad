package com.example.core.base.navigation

import android.content.Intent

const val PACKAGE_NAME = "com.example.goalsquad"
private val classes = mutableMapOf<String, Class<*>>()

private inline fun <reified T : Any> Any.cast() = this as? T

private fun intentTo(className: String) =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)

private fun <T> String.getFeature(): Class<out T>? =
    classes.getOrPut(this) {
        try {
            Class.forName(this)
        } catch (e: ClassNotFoundException) {
            return null
        }
    }.cast()


fun String.createIntentFeature() = try {
    Class.forName(this).run { intentTo(this@createIntentFeature) }
} catch (e: ClassNotFoundException) {
    null
}

