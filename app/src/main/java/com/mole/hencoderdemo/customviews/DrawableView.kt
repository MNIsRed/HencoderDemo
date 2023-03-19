package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import com.mole.hencoderdemo.CustomDrawable

class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val mDrawables = arrayListOf(CustomDrawable(Color.RED),CustomDrawable(Color.YELLOW),
        CustomDrawable(Color.GREEN),CustomDrawable(Color.YELLOW),CustomDrawable(Color.RED),CustomDrawable(Color.RED)
    ,CustomDrawable(Color.GREEN),CustomDrawable(Color.RED))
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        for ((index,drawable) in mDrawables.withIndex()){
            val left = index * width/(mDrawables.size+1).toFloat()
            canvas.drawBitmap(drawable.toBitmap(50,100),left,0f,paint)
        }
    }
}