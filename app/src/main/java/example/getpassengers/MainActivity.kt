package example.getpassengers
// William Maddock

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

// Define Passenger class outside MainActivity
data class Passenger(val fName: String, val lName: String, val phone: String) {
    override fun toString(): String = "$fName $lName $phone"
}

class MainActivity : AppCompatActivity() {
    private lateinit var listText: TextView

    // ActivityResultLauncher to handle callback
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val count = data?.getStringExtra("COUNT")?.toIntOrNull() ?: 0
            listText.text = "Returned Passenger List:\n" // Ensure proper clearing and format

            for (i in 1..count) {
                val passenger = data?.getStringExtra("PASS$i") ?: ""
                listText.append("$passenger\n") // Append each passenger in a new line
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listText = findViewById(R.id.show_list)
    }

    // Called when "GET PASSENGER LIST" button is clicked
    fun getList(view: View) {
        listText.text = "Returned Passenger List:\n" // Clear previous data
        val intent = Intent(this, GetPassengersActivity::class.java)
        startForResult.launch(intent)
    }
}