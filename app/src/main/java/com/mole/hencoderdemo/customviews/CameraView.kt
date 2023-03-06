package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.R
import com.mole.hencoderdemo.dp
import com.mole.hencoderdemo.utils.BitmapUtils

private val IMAGE_WIDTH = 200.dp
private val IMAGE_PADDING = 100.dp
class CameraView @JvmOverloads constructor(context: Context, attrs: AttributeSet?= null):View(context,attrs) {
    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        val bitmap = BitmapUtils.getBitmap(resources,R.drawable.avatar_rengwuxian,IMAGE_WIDTH.toInt())
        canvas.clipRect(IMAGE_PADDING,IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH/2)
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint)
    }
}