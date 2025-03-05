package example.getpassengers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GetPassengersActivity : AppCompatActivity() {
    private lateinit var accumList: TextView
    private val passList: MutableList<Passenger> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_passengers)
        accumList = findViewById(R.id.accum_list)
    }

    fun enterPassenger(view: View) {
        val firstName = findViewById<EditText>(R.id.first_name).text.toString().trim()
        val lastName = findViewById<EditText>(R.id.last_name).text.toString().trim()
        val phone = findViewById<EditText>(R.id.phone_number).text.toString().trim()

        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
            return
        }

        val passenger = Passenger(firstName, lastName, phone)
        passList.add(passenger)
        accumList.append("$passenger\n")

        // Clear input fields
        findViewById<EditText>(R.id.first_name).text.clear()
        findViewById<EditText>(R.id.last_name).text.clear()
        findViewById<EditText>(R.id.phone_number).text.clear()
    }

    // ADD THIS FUNCTION
    fun backToMain(view: View) {
        val resultIntent = Intent()
        resultIntent.putExtra("COUNT", passList.size.toString())
        for (i in passList.indices) {
            resultIntent.putExtra("PASS${i + 1}", passList[i].toString())
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}