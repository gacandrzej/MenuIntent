package gac.andrzej.menu

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MonteCarlo : AppCompatActivity() {
    private val TAG = "Android"
    private lateinit var algorithms: Algorithms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_monte_carlo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        algorithms = Algorithms()
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val iloscPunktow = intent.getDoubleExtra("ilosc_punktow", 0.0)

        Log.d(TAG, "<------------- ilosc punktow: ${String.format("%.2f", iloscPunktow)}")

        val wartoscPi = algorithms.monteCarlo(iloscPunktow)
        Log.d(TAG, "<-------------wartosc pi---------------------->${String.format("%.9f", wartoscPi)}")
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.v(TAG, "--------MonteCarlo-------onSupportNavigateUp()")
        finish()
        return true
    }
}