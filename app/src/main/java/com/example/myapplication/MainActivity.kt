package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate_tip.SetOnClickListener{
            CalculateTip()
        }
    }

    fun CalculateTip(){
        var ServiceCostText = binding.text_input.text.toString()
        var cost = ServiceCostText.toDouble()
        var selectedId = binding.group.checkedRadioButtonId
        val tipPercentage = when(selectedId){
            R.id.twenty -> 0.20
            R.id.eighteen -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundTip = binding.roundOff.isChecked
        if (roundTip){
            tip = Kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

    }
}