package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.R
import com.mole.hencoderdemo.dp
import com.mole.hencoderdemo.utils.BitmapUtils

private val RING_WIDTH = 20.dp
private val RADIOUS = 100.dp
private val IMAGE_WIDTH = RADIOUS
private val IMAGE_END_PADDING = 10.dp
private val IMAGE_TOP_PADDING = 50.dp
private const val TEXT = "Test文案"
private const val LONG_TEXT =
    """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porta nibh vitae erat fringilla imperdiet. Vestibulum vitae leo odio. Aenean ac aliquet arcu. Morbi sed venenatis arcu. Nunc rutrum malesuada fermentum. Phasellus malesuada lacus nec libero consectetur, sed lobortis massa sodales. Donec maximus nulla rhoncus ante blandit aliquam. In id suscipit lectus. """

class SportView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 20.dp
        textAlign = Paint.Align.CENTER
    }
    private val bitmap =
        BitmapUtils.getBitmap(resources, R.drawable.avatar_rengwuxian, 100.dp.toInt())
    private val bounds = Rect()
    private val measuredWidth = floatArrayOf(0f)
    override fun onDraw(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = RING_WIDTH
        paint.color = Color.GRAY
        canvas.drawCircle(width / 2f, height / 4f, RADIOUS, paint)
        paint.color = Color.BLUE
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIOUS,
            height / 4f - RADIOUS,
            width / 2f + RADIOUS,
            height / 4f + RADIOUS,
            -90f,
            270f,
            false,
            paint
        )

        paint.style = Paint.Style.FILL
        paint.getTextBounds(TEXT, 0, TEXT.length, bounds)
        canvas.drawText(TEXT, width / 2f, height / 4f - bounds.top, paint)

        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(TEXT, -bounds.left.toFloat(), -paint.fontMetrics.top, paint)
        paint.breakText(TEXT.toCharArray(), 0, TEXT.length, width.toFloat(), measuredWidth)
        paint.textAlign = Paint.Align.RIGHT
        paint.getTextBounds(TEXT, 0, TEXT.length, bounds)
        canvas.drawText(TEXT, width.toFloat(), -paint.fontMetrics.ascent, paint)

        var start = 0
        var count: Int
        var maxWidth: Float
        var verticalOffset = height / 2f - paint.fontMetrics.top + paint.fontMetrics.bottom
        paint.textAlign = Paint.Align.LEFT

        canvas.drawBitmap(
            bitmap,
            width - IMAGE_WIDTH - IMAGE_END_PADDING,
            height / 2f + IMAGE_TOP_PADDING,
            paint
        )

        while (start < LONG_TEXT.length) {
            maxWidth =
                if ((verticalOffset + paint.fontMetrics.bottom) < (height / 2 + IMAGE_TOP_PADDING)
                    || (verticalOffset + paint.fontMetrics.top) > (height / 2 + IMAGE_TOP_PADDING + IMAGE_WIDTH)
                ) {
                    width.toFloat()
                } else {
                    width - IMAGE_WIDTH - IMAGE_END_PADDING
                }
            count = paint.breakText(
                LONG_TEXT.toCharArray(),
                start,
                LONG_TEXT.length - start,
                maxWidth,
                measuredWidth
            )

            if (count == 0) {
                break
            }
            canvas.drawText(
                LONG_TEXT,
                start,
                start + count,
                -bounds.left.toFloat(),
                verticalOffset,
                paint
            )
            verticalOffset += paint.fontMetrics.bottom - paint.fontMetrics.top
            start += count
        }
    }
}