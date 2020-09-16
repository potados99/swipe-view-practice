package org.potados.swipeviewpractice

import android.util.Log

class Reporter(private val name: String) {

    private var reportCount: Int = 0

    fun report() {
        Log.i(name, "Total: ${++reportCount}")
    }

    companion object {
        val outer = Reporter("Outer")
        val inner = Reporter("Inner")
    }
}