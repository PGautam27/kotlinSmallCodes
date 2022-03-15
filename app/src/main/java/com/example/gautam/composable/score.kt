package com.example.gautam.composable

import androidx.compose.ui.graphics.Color
import com.example.gautam.ui.theme.*

data class score(val value : Int){
    var status = getStatus(value)
    var color = getColor(value)
    var textColor = getTextColor(value)
    private fun getStatus(value : Int):String{
        return when(value){
            in 0..30 -> "LOW"
            in 31..65 -> "MODERATE"
            in 66..100 -> "HIGH"
            else -> "LOW"
        }
    }
    private fun getColor(value:Int): Color {
        return when(value){
            in 0..30 -> lightRed
            in 31..65 -> lightOrange
            in 66..100 -> lightGreen
            else -> lightRed
        }
    }
    private fun getTextColor(value: Int): Color {
        return when(value){
            in 0..30 -> lightRedText
            in 31..65 -> lightOrangeText
            in 66..100 -> lightGreenText
            else -> lightRedText
        }
    }
}