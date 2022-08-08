package com.journeyassignment.misc

inline fun <reified T> Any?.tryCast(block: T.() -> Unit) {
    if (this is T) {
        block()
    }
}