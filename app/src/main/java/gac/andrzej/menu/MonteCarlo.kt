package gac.andrzej.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MonteCarlo : AppCompatActivity() {
    private val TAG = "Android"
    private lateinit var algorithms: Algorithms
    private lateinit var tvPi: TextView
    @SuppressLint("MissingInflatedId")
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
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tvPi = findViewById(R.id.tvPi)

        val intent = intent
        val iloscPunktow = intent.getDoubleExtra("ilosc_punktow", 0.0)

        val formatIloscPunktow = String.format("%.2f", iloscPunktow)
        Log.d(TAG, "<------------- ilosc punktow: $formatIloscPunktow")

        val wartoscPi = algorithms.monteCarlo(iloscPunktow)
        val formatWartoscPi = String.format("%.9f", wartoscPi)
        Log.d(TAG, "<-------------wartosc pi---------------------->$formatWartoscPi")
        var sb=StringBuffer()
        sb.append("Ilość punktów: ").append(formatIloscPunktow)
            .append("\nPi~").append(formatWartoscPi)

        tvPi.text = sb
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.v(TAG, "--------MonteCarlo-------onSupportNavigateUp()")
        finish()
        return true
    }
}