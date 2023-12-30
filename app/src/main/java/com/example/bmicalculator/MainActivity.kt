package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

private var weight: Double = .0
private var height: Double = .0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        btnCalculate.setOnClickListener {
            try {
                weight = etWeight.text.toString().toDouble()
                height = etHeight.text.toString().toDouble()
            } catch (e: Exception) {
            }
            var result: Double = .0
            if (weight != .0 && height != .0) {
                result = weight / (height * height) * 100 / 100
            }
            //to two decimals
            result = String.format("%.2f", result).toDouble()
            tvBMI.text = result.toString()
            showStatus(result)
        }
    }

    private fun showStatus(result: Double) {
        val tvBMI = findViewById<TextView>(R.id.tvStatus)
        when {
            result < 18.5 -> {
                tvBMI.text = "underweight"
                tvBMI.setTextColor(ContextCompat.getColor(this,R.color.overWeight))
            }
            result < 25 -> {
                tvBMI.text = "healthy"
                tvBMI.setTextColor(ContextCompat.getColor(this,R.color.normal))
            }
            result < 30 -> {
                tvBMI.text = "overweight"
                tvBMI.setTextColor(ContextCompat.getColor(this,R.color.overWeight))
            }
            result < 40 -> {
                tvBMI.text = "obese"
                tvBMI.setTextColor(ContextCompat.getColor(this,R.color.obese))
            }
        }
    }
}