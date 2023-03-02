package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mole.hencoderdemo.R
import com.mole.hencoderdemo.px
import com.mole.hencoderdemo.utils.BitmapUtils

private val IMAGE_WIDTH = 100f.px
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
private val INNER_PADDING = 3f.px
class AvatarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs){

    private val bounds = RectF(IMAGE_WIDTH/2 - INNER_PADDING,IMAGE_WIDTH/2 - INNER_PADDING, IMAGE_WIDTH*3/2 + INNER_PADDING , IMAGE_WIDTH*3/2 + INNER_PADDING)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds,null)
        canvas.drawOval(IMAGE_WIDTH/2,IMAGE_WIDTH/2, IMAGE_WIDTH*3/2, IMAGE_WIDTH*3/2,paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(BitmapUtils.getBitmap(resources, R.drawable.avatar_rengwuxian, IMAGE_WIDTH.toInt()), IMAGE_WIDTH/2, IMAGE_WIDTH/2,paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        canvas.drawCircle(IMAGE_WIDTH,IMAGE_WIDTH, IMAGE_WIDTH/2 + INNER_PADDING, paint)
        canvas.restoreToCount(count)
    }
}
