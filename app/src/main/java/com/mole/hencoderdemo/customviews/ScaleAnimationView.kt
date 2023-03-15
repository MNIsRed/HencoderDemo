package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.dp

class ScaleAnimationView @JvmOverloads constructor(context:Context, attrs:AttributeSet? = null):View(context, attrs){
    private val paint: Paint = Paint()
    var radius: Float = 50.dp
    set(value) {
        field = value
        invalidate()
    }

    init {
        paint.color = Color.WHITE
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width/2f,height/2f,radius,paint)
    }
}