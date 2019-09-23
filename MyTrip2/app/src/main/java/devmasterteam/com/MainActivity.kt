package devmasterteam.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            handleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }


    private fun handleCalculate() {
        if (isValid()) {
            try {
                // verificacao da distancia e autonomia
                val distance = editDistancia.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val result = ((distance * price) / autonomy)

                textResult.setText("Total: R$ $result")

            } catch (e: NumberFormatException) {
                Toast.makeText(this, getString(R.string.valoresValidos), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, getString(R.string.valoresValidos), Toast.LENGTH_LONG).show()
        }
    }

    private fun isValid(): Boolean {
        return !editDistancia.text.isNullOrEmpty() &&
                !editPrice.text.isNullOrEmpty() &&
                !editAutonomy.text.isNullOrEmpty() &&
                editAutonomy.text.toString() != "0"
    }


}
