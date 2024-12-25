package gac.andrzej.menu

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewtonRaphson : AppCompatActivity() {
    private val TAG = "Android"
    private lateinit var algorithms: Algorithms

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
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val liczba = intent.getDoubleExtra("liczba", 0.0)
        val precyzja = intent.getDoubleExtra("precyzja", 0.0)

        Log.d(TAG, "<-------------liczba i precyzja: ${String.format("%.9f", liczba)} ${String.format("%.9f", precyzja)}")

        val pierwiastek = algorithms.newtonRaphson(liczba, precyzja)
        Log.d(TAG, "<-------------pierwiastek---------------------->$pierwiastek")
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.v(TAG, "--------NewtonRaphson-------onSupportNavigateUp()")
        finish()
        return true
    }
}