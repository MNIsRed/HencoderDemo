package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.color
import com.mole.hencoderdemo.dp
import kotlin.math.cos
import kotlin.math.sin

private val pieAngles = floatArrayOf(60f,90f,150f,60f)
private val pieColors = listOf("#C21858".color,"#00ACC1".color,"#55882F".color,"#504037".color)
private val RADIUS = 80f.dp
private const val DIVIDE_INDEX = 2
private val DIVIDE = 3f.dp
class PieChatView @JvmOverloads constructor(context: Context,attrs: AttributeSet? = null) :
    View(context,attrs) {

    private val paint: Paint = Paint()

    override fun draw(canvas: Canvas) {
        var startAngle = 0f
        for ((index,angle) in pieAngles.withIndex()){
            paint.color = pieColors[index]
            if (index == DIVIDE_INDEX){
                canvas.save()
                canvas.translate((DIVIDE * cos(Math.toRadians((startAngle+angle).toDouble()/2))).toFloat(),(-DIVIDE * sin(Math.toRadians(startAngle.toDouble()/2))).toFloat())
            }
            canvas.drawArc(width/2 - RADIUS,height/2 - RADIUS,width/2 + RADIUS,height /2+RADIUS,startAngle,angle,true,paint)
            if (index == DIVIDE_INDEX){
                canvas.restore()
            }
            startAngle += angle
        }
    }
}