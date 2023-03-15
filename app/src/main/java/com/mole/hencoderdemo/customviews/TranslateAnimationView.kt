package com.mole.hencoderdemo.customviews

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * 考验自定义TypeEvaluator，做点坐标改变动画
 */
class TranslateAnimationView @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) : View(context,attrs) {
    //需要用属性动画改变的属性不可设置为private
    var pointF : PointF = PointF()
    set(value) {
        field = value
        invalidate()
    }
    private val paint : Paint = Paint()

    init {
        paint.color = Color.WHITE
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(pointF.x,pointF.y,20f,paint)
    }
}

class PointFTypeEvaluator : TypeEvaluator<PointF>{
    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
        val currentPointF = PointF()
        currentPointF.x = startValue.x + (endValue.x - startValue.x) * fraction
        currentPointF.y = startValue.y + (endValue.y - startValue.y) * fraction
        return currentPointF
    }

}