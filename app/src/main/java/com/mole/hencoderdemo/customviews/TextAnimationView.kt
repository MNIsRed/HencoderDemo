package com.mole.hencoderdemo.customviews

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.dp

val PROVINCES = arrayListOf<String>("海南省",
"东北","大兴安岭","shanghai","yskn","内蒙古自治区","new Province")
class TextAnimationView @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) : View(context,attrs){
    private val paint: Paint = Paint()
    var showText : String = "海南省"
    set(value) {
        field = value
        invalidate()
    }
    init {
        paint.color = Color.WHITE
        paint.textSize = 15.dp
        paint.textAlign = Paint.Align.CENTER
    }
    override fun onDraw(canvas: Canvas) {
        canvas.drawText(showText,width/2f,height/2f,paint)
    }
}

class TextTypeEvaluator : TypeEvaluator<String>{
    override fun evaluate(fraction: Float, startValue: String, endValue: String): String {
        val startIndex = PROVINCES.indexOf(startValue)
        val endIndex = PROVINCES.indexOf(endValue)
        val currentIndex = (startIndex + (endIndex - startIndex)*fraction).toInt()
        return PROVINCES[currentIndex]
    }
}