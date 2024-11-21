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
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonDecimal: Button
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonDelete: Button

    private var currentInput = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.displayTextView)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonDecimal = findViewById(R.id.buttonDecimal)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonClear = findViewById(R.id.buttonClear)
        buttonDelete = findViewById(R.id.buttonDelete)

        button0.setOnClickListener{ appendInput("0")}
        button1.setOnClickListener{ appendInput("1")}
        button2.setOnClickListener { appendInput("2") }
        button3.setOnClickListener { appendInput("3") }
        button4.setOnClickListener { appendInput("4") }
        button5.setOnClickListener { appendInput("5") }
        button6.setOnClickListener { appendInput("6") }
        button7.setOnClickListener { appendInput("7") }
        button8.setOnClickListener { appendInput("8") }
        button9.setOnClickListener { appendInput("9") }
        buttonDecimal.setOnClickListener { appendInput(".") }
        buttonAdd.setOnClickListener { setOperator("+") }
        buttonSubtract.setOnClickListener { setOperator("-") }
        buttonMultiply.setOnClickListener { setOperator("*") }
        buttonDivide.setOnClickListener { setOperator("/") }
        buttonEqual.setOnClickListener { calculateResult() }
        buttonClear.setOnClickListener { clear() }
        buttonDelete.setOnClickListener { deleteLast() }

//        val buttons = listOf(
//            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
//            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
//            R.id.buttonDecimal, R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply,
//            R.id.buttonDivide, R.id.buttonEqual, R.id.buttonClear, R.id.buttonDelete
//        )

//        for (id in buttons) {
//            findViewById<Button>(id).setOnClickListener { onButtonClick(it as Button) }
//        }

    }

    private fun appendInput(value: String){
        currentInput += value
        displayTextView.text = currentInput

    }

    private fun setOperator(value: String){
        if(currentInput.isNotEmpty()){
            firstOperand = currentInput.toDouble()
            operator = value
            currentInput = ""
            displayTextView.text = operator
        }
    }

    private fun calculateResult(){
        if(operator.isNotEmpty() && currentInput.isNotEmpty()){
            secondOperand = currentInput.toDouble()
            val result = when(operator){
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "*" -> firstOperand * secondOperand
                "/" -> if(secondOperand != 0.0) firstOperand/secondOperand else "Error"
                else -> "ERROR"
            }
            displayTextView.text = result.toString()
            currentInput = result.toString()
            operator=""
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

//    private fun onButtonClick(button: Button) {
//        when (val value = button.text.toString()) {
//            "C" -> clear()
//            "DEL" -> deleteLast()
//            "+", "-", "*", "/" -> setOperator(value)
//            "=" -> calculateResult()
//            else -> appendInput(value)
//        }
//    }
//
//    private fun appendInput(value: String) {
//        currentInput += value
//        displayTextView.text = currentInput
//    }
//
//    private fun setOperator(value: String) {
//        if (currentInput.isNotEmpty()) {
//            firstOperand = currentInput.toDouble()
//            operator = value
//            currentInput = ""
//            displayTextView.text = operator
//        }
//    }
//
//    private fun calculateResult() {
//        if (operator.isNotEmpty() && currentInput.isNotEmpty()) {
//            secondOperand = currentInput.toDouble()
//            val result = when (operator) {
//                "+" -> firstOperand + secondOperand
//                "-" -> firstOperand - secondOperand
//                "*" -> firstOperand * secondOperand
//                "/" -> if (secondOperand != 0.0) firstOperand / secondOperand else "Error"
//                else -> "Error"
//            }
//            displayTextView.text = result.toString()
//            currentInput = result.toString()
//            operator = ""
//        }
//    }
//
//    private fun clear() {
//        currentInput = ""
//        firstOperand = 0.0
//        secondOperand = 0.0
//        operator = ""
//        displayTextView.text = "0"
//    }
//
//    private fun deleteLast() {
//        if (currentInput.isNotEmpty()) {
//            currentInput = currentInput.dropLast(1)
//            displayTextView.text = currentInput
//        }
//    }

}