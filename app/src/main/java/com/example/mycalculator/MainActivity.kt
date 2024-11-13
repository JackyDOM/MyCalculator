package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var displayTextView: TextView
    private var currentInput = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.displayTextView)

        val buttons = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonDecimal, R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply,
            R.id.buttonDivide, R.id.buttonEqual, R.id.buttonClear, R.id.buttonDelete
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { onButtonClick(it as Button) }
        }

    }

    private fun onButtonClick(button: Button) {
        when (val value = button.text.toString()) {
            "C" -> clear()
            "DEL" -> deleteLast()
            "+", "-", "*", "/" -> setOperator(value)
            "=" -> calculateResult()
            else -> appendInput(value)
        }
    }

    private fun appendInput(value: String) {
        currentInput += value
        displayTextView.text = currentInput
    }

    private fun setOperator(value: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operator = value
            currentInput = ""
            displayTextView.text = operator
        }
    }

    private fun calculateResult() {
        if (operator.isNotEmpty() && currentInput.isNotEmpty()) {
            secondOperand = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "*" -> firstOperand * secondOperand
                "/" -> if (secondOperand != 0.0) firstOperand / secondOperand else "Error"
                else -> "Error"
            }
            displayTextView.text = result.toString()
            currentInput = result.toString()
            operator = ""
        }
    }

    private fun clear() {
        currentInput = ""
        firstOperand = 0.0
        secondOperand = 0.0
        operator = ""
        displayTextView.text = "0"
    }

    private fun deleteLast() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            displayTextView.text = currentInput
        }
    }

}