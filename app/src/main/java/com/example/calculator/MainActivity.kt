package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        if (second_operand.text.toString().isNotEmpty() && operation != null){
            equal_operand.isEnabled = true
        }

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
}