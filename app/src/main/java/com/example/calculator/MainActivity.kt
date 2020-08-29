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
            plus_operand.setBackgroundResource(R.drawable.green_border)
            subtract_operand.setBackgroundResource(0)
            multiply_operand.setBackgroundResource(0)
            divide_operand.setBackgroundResource(0)
        }
        subtract_operand.setOnClickListener {
            operation = '-'
            plus_operand.setBackgroundResource(0)
            subtract_operand.setBackgroundResource(R.drawable.green_border)
            multiply_operand.setBackgroundResource(0)
            divide_operand.setBackgroundResource(0)
        }
        multiply_operand.setOnClickListener {
            operation = '*'
            plus_operand.setBackgroundResource(0)
            subtract_operand.setBackgroundResource(0)
            multiply_operand.setBackgroundResource(R.drawable.green_border)
            divide_operand.setBackgroundResource(0)
        }
        divide_operand.setOnClickListener {
            operation = '/'
            plus_operand.setBackgroundResource(0)
            subtract_operand.setBackgroundResource(0)
            multiply_operand.setBackgroundResource(0)
            divide_operand.setBackgroundResource(R.drawable.green_border)
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

            when (operation){

                '+' -> result_value.text =
                        (result_value.text.toString().toDouble() + second_operand.text.toString().toDouble()).toString()

                '-' ->result_value.text =
                    (result_value.text.toString().toDouble() - second_operand.text.toString().toDouble()).toString()

                '*' -> result_value.text =
                    (result_value.text.toString().toDouble() * second_operand.text.toString().toDouble()).toString()

                '/' ->
                    if(second_operand.text.toString().toDouble() == 0.0)
                        Toast.makeText(this,"division by zero unacceptable", Toast.LENGTH_SHORT).show()
                    else {
                        result_value.text =
                            (result_value.text.toString().toDouble() / second_operand.text.toString().toDouble()).toString()
                    }

            }
        }
    }

    fun checkEqualButton(){
        if (second_operand.text.toString().isNotEmpty() && operation != null){
            equal_operand.isEnabled = true
        }
    }
}