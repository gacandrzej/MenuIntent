package gac.andrzej.mytestkot

import android.util.Log
import java.util.TreeSet
import kotlin.random.Random

class Algorithms {

    private val TAG = "Android"

    fun monteCarlo(n: Double): Double {
        val random = Random
        var T = 0.0
        var R = 0.0
        do {
            val a = random.nextDouble()
            val b = random.nextDouble()
            if (Math.pow(a, 2.0) + Math.pow(b, 2.0) < 1) T++
            R++
        } while (R < n)
        return 4.0 * T / R
    }

    fun random6(): String {
        val random = Random
        val treeSet = TreeSet<Int>()
        while (treeSet.size < 6) {
            treeSet.add(1 + random.nextInt(48))
        }

        Log.d(TAG, "random6: list:" + treeSet)
        return ""
    }

    fun newtonRaphson(x: Double, d: Double): Double {
        var a = 5.0
        while (Math.abs(x / a - a) > d) {
            a = (x / a + a) / 2
            Log.i("NR", "$x / $a + $a")
        }
        Log.d(TAG, "newtonRaphson() returned: $a")
        return a
    }
    fun countingSort() {
        val liczby = mutableListOf<Int>()
        val liczbyMap = mutableMapOf<Int, Int>()

        val random = Random
        for (i in 0 until 50) {
            liczby.add(random.nextInt(100))
        }

        val highest = liczby.maxOrNull() ?: 0
        for (i in 0 until highest) {
            liczbyMap[i] = 0
        }
        Log.i(TAG, liczbyMap.toString())

        for (x in liczby) {
            liczbyMap[x] = liczbyMap[x]?.plus(1) ?: 1
        }
        Log.i(TAG, liczbyMap.toString())
        liczby.clear()

        for (i in 1 until liczbyMap.size) {
            for (y in 0 until liczbyMap[i]!!) {
                liczby.add(i)
            }
        }
        val text = StringBuilder()
        for (x in liczby) {
            text.append("$x ")
        }
        Log.i(TAG, liczby.toString())
    }

}
