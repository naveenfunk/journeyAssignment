package com.journeyassignment.misc

import android.util.Log
import com.journeyassignment.BuildConfig

fun log(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e("JA", message)
    }
}