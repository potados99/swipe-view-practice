package org.potados.swipeviewpractice

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.ceil

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculationTest {
    @Test
    fun pageCount_isCorrect() {
        val formula = { left: Int, right: Int -> ceil(left.toDouble()/right).toInt() }

        assertEquals(formula(1, 3), 1)
        assertEquals(formula(2, 3), 1)
        assertEquals(formula(3, 3), 1)

        assertEquals(formula(4, 3), 2)
        assertEquals(formula(5, 3), 2)
        assertEquals(formula(6, 3), 2)
    }
}