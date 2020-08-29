package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operation : Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus_operand.setOnClickListener {
            operation = '+'
            selectPlus()
            checkEqualButton()
        }
        subtract_operand.setOnClickListener {
            operation = '-'
            selectSubtract()
            checkEqualButton()
        }
        multiply_operand.setOnClickListener {
            operation = '*'
            selectMultiply()
            checkEqualButton()
        }
        divide_operand.setOnClickListener {
            operation = '/'
            selectDivision()
            checkEqualButton()
        }

        second_operand.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                checkEqualButton()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                
            }

        })

        equal_operand.setOnClickListener {

            result_value.text = computeTheOperation()
            second_operand.text.clear()
            deselectButtons()
        }
    }

    private fun computeTheOperation() : String{

        return when (operation) {

            '+' -> (result_value.text.toString().toDouble() + second_operand.text.toString()
                .toDouble()).toString()

            '-' -> (result_value.text.toString().toDouble() - second_operand.text.toString()
                .toDouble()).toString()

            '*' -> (result_value.text.toString().toDouble() * second_operand.text.toString()
                .toDouble()).toString()

            '/' ->
                if (second_operand.text.toString().toDouble() == 0.0){
                    Toast.makeText(this, "division by zero unacceptable", Toast.LENGTH_SHORT).show()
                    result_value.text.toString()
                }else {
                    (result_value.text.toString().toDouble() / second_operand.text.toString().toDouble()).toString()
                }

            else -> result_value.text.toString()
        }
    }

    fun checkEqualButton(){
        equal_operand.isEnabled = second_operand.text.toString().isNotEmpty() && operation != null
    }

    private fun selectPlus(){
        plus_operand.setBackgroundResource(R.drawable.green_border)
        subtract_operand.setBackgroundResource(0)
        multiply_operand.setBackgroundResource(0)
        divide_operand.setBackgroundResource(0)
    }
    private fun selectSubtract(){
        plus_operand.setBackgroundResource(0)
        subtract_operand.setBackgroundResource(R.drawable.green_border)
        multiply_operand.setBackgroundResource(0)
        divide_operand.setBackgroundResource(0)
    }
    private fun selectMultiply(){
        plus_operand.setBackgroundResource(0)
        subtract_operand.setBackgroundResource(0)
        multiply_operand.setBackgroundResource(R.drawable.green_border)
        divide_operand.setBackgroundResource(0)
    }
    private fun selectDivision(){
        plus_operand.setBackgroundResource(0)
        subtract_operand.setBackgroundResource(0)
        multiply_operand.setBackgroundResource(0)
        divide_operand.setBackgroundResource(R.drawable.green_border)
    }
    private fun deselectButtons(){
        plus_operand.setBackgroundResource(0)
        subtract_operand.setBackgroundResource(0)
        multiply_operand.setBackgroundResource(0)
        divide_operand.setBackgroundResource(0)
    }
}