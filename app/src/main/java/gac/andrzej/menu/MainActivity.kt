package gac.andrzej.menu


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val TAG = "Android"
    private lateinit var algorithms: Algorithms
    private lateinit var btnNewton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.toolbar))

        algorithms = Algorithms()
        btnNewton = findViewById(R.id.btnnewtonraphson)
        btnNewton.setOnClickListener {
            Log.d(TAG, "onClick: ")
            intentNewtonRaphson()
        }
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.losuj -> {
                algorithms.random6()
                return true
            }
            R.id.newtonraphson -> {
                intentNewtonRaphson()
                Log.d(TAG, "onOptionsItemSelected: ")
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.montecarlo -> {
                intentMonteCarlo()
                Log.d(TAG, "onOptionsItemSelected: ")
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.sortzliczanie -> {
                intentCountingSort()
                return true
            }
            R.id.aboutAuthor -> {
                aboutAuthor()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun intentCountingSort() {

    }

    private fun intentNewtonRaphson() {
        Toast.makeText(this, "NewtonRaphson()", Toast.LENGTH_SHORT).show()
      // val intent = Intent(this, NewtonRaphson::class)
        val intent = Intent(this,NewtonRaphson::class.java)
        intent.putExtra("liczba", 9.0)
        intent.putExtra("precyzja", 0.0001)
        startActivity(intent)
        Log.v(TAG, "<--------------- NewtonRaphson()")
    }

    private fun intentMonteCarlo() {
        val iloscPunktowEditText = findViewById<EditText>(R.id.iloscPunktow)
        val ilPunktow = iloscPunktowEditText.text.toString().toDoubleOrNull() ?: 0.0
        val intent = Intent(this, MonteCarlo::class.java)
        intent.putExtra("ilosc_punktow", ilPunktow)
        startActivity(intent)
        Log.v(TAG, "<--------------- monteCarlo()")
    }

    private fun aboutAuthor() {
        val builder = AlertDialog.Builder(this)
            .setMessage("Author: Andrzej Gac")
            .setTitle("---Simple alert application---")
            .setNegativeButton(R.string.ok) { dialog, which -> Log.i(TAG, "------------------------> ok") }
            .setPositiveButton(R.string.cancel) { dialog, which -> Log.i(TAG, "------------------------> cancel") }
            .create()
        builder.show()
    }

    override fun onPause() {
        super.onPause()
        println("test")
        Log.d(TAG, "onPause() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() called")
    }

    fun LosujLiczby(view: View) {
        Toast.makeText(this, "Test przycisku", Toast.LENGTH_SHORT).show()
        Log.v(TAG, "<--------------- Test przycisku")
    }
}