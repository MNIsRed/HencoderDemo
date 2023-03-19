package com.mole.hencoderdemo

import android.graphics.*
import android.graphics.drawable.Drawable

class CustomDrawable(colorInt: Int) : Drawable() {
    private val mPaint = Paint()
    private val mRect = Rect(0,0,50,100)
    private val xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

    init {
        mPaint.color = colorInt
    }
    override fun draw(canvas: Canvas) {
        canvas.drawRect(0f, 0f, 50f, 100f, mPaint)
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
        invalidateSelf()
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }
}