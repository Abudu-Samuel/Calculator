package leumas.com.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mathOperator = "*"
    private var firstInput = ""
    private var isEmpty = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClicked(view: View) {
        if (isEmpty) {
            showText.setText(" ")
        }
        isEmpty = false
        val btnSelected = view as Button
        var textDisplayed = showText.text.toString()

        when (btnSelected.id) {
            btn0.id -> textDisplayed += "0"
            btn1.id -> textDisplayed += "1"
            btn2.id -> textDisplayed += "2"
            btn3.id -> textDisplayed += "3"
            btn4.id -> textDisplayed += "4"
            btn5.id -> textDisplayed += "5"
            btn6.id -> textDisplayed += "6"
            btn7.id -> textDisplayed += "7"
            btn8.id -> textDisplayed += "8"
            btn9.id -> textDisplayed += "9"
            btnDot.id -> textDisplayed += "."
        }

        showText.setText(textDisplayed)
    }

    fun btnOps(view: View) {
        val btnSelected = view as Button

        when (btnSelected.id) {
            btnDiv.id -> mathOperator = "/"
            btnMul.id -> mathOperator = "*"
            btnMin.id -> mathOperator = "-"
            btnAdd.id -> mathOperator = "+"
        }
        firstInput = showText.text.toString()
        isEmpty = true
    }

    fun submitBtn(view: View) {
        var total: Double? = null
        val finalInput = showText.text.toString()

        when (mathOperator) {
            "*" -> total = firstInput.toDouble() * finalInput.toDouble()
            "/" -> total = firstInput.toDouble() / finalInput.toDouble()
            "-" -> total = firstInput.toDouble() - finalInput.toDouble()
            "+" -> total = firstInput.toDouble() + finalInput.toDouble()
        }

        showText.setText(total.toString())
        isEmpty = true

    }

    fun percentageBtn(view: View) {
        val inputValue: Double = showText.text.toString().toDouble() / 100
        showText.setText(inputValue.toString())
        isEmpty = true
    }

    fun clearBtn(view: View) {
        showText.setText("")
        isEmpty = true
    }

}
