package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathDashPathEffect
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * 仪表盘
 */
private val RADIUS = 80f.dp
private const val OPEN_ANGEL = 120f
private val DASH_HEIGHT = 5f.dp
private val DASH_WIDTH = 2f.dp
private const val DASH_COUNT = 20
private val LINE_LENGTH = 60f.dp
private const val LINE_LEVEL = 10
class DashArcView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null):View(context,attrs){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val dashShapePath = Path()
    private lateinit var dashPathEffect : PathDashPathEffect
    init {
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 3f.dp

        dashShapePath.addRect(0f,0f, DASH_WIDTH, DASH_HEIGHT,Path.Direction.CW)
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(w/2 - RADIUS , h/2 - RADIUS, w/2 + RADIUS, h/2 + RADIUS,90f + OPEN_ANGEL/2,360- OPEN_ANGEL)
        val pathMeasure = PathMeasure(path,false)
        dashPathEffect = PathDashPathEffect(dashShapePath,(pathMeasure.length - DASH_WIDTH)/ DASH_COUNT,0f,PathDashPathEffect.Style.ROTATE)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawPath(path,paint)
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path,paint)
        paint.pathEffect = null

        canvas.drawLine(width/2f , height/2f, (width/2 + LINE_LENGTH * cos(getRadians())).toFloat(),(height/2+ LINE_LENGTH * sin(getRadians())).toFloat(),paint)
    }

    private fun getRadians():Double{
        return Math.toRadians((90f + OPEN_ANGEL/2 + LINE_LEVEL * (360- OPEN_ANGEL)/ DASH_COUNT).toDouble())
    }
}