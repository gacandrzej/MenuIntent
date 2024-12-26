package gac.andrzej.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewtonRaphson : AppCompatActivity() {
    private val TAG = "Android"
    private lateinit var algorithms: Algorithms
    private lateinit var tvPie: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_newton_raphson)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        algorithms = Algorithms()
        setSupportActionBar(findViewById(R.id.toolbar3))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tvPie = findViewById(R.id.tvPierwiastek)

        val intent = intent
        val liczba = intent.getDoubleExtra("liczba", 0.0)
        val precyzja = intent.getDoubleExtra("precyzja", 0.0)

        val formatLiczba = String.format("%.2f", liczba)
        val formatPrecyzja = String.format("%.4f", precyzja)
        Log.d(TAG, "<-------------liczba i precyzja: $formatLiczba $formatPrecyzja")
        val pierwiastek = algorithms.newtonRaphson(liczba, precyzja)
        Log.d(TAG, "<-------------pierwiastek---------------------->$pierwiastek")
        var sb=StringBuffer()
        val formatPierwiastek = String.format("%.4f", pierwiastek)
        sb.append("Liczba: ").append(formatLiczba)
            .append("\nprecyzja ").append(formatPrecyzja)
            .append("\npierwiastek: ").append(formatPierwiastek)
        tvPie.text = sb
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.v(TAG, "--------NewtonRaphson-------onSupportNavigateUp()")
        finish()
        return true
    }
}