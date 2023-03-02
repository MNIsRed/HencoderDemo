package com.mole.hencoderdemo.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes

class BitmapUtils {
    companion object{
        @JvmStatic
        fun getBitmap(resources:Resources,@DrawableRes resId: Int,width:Int): Bitmap{
            val options = BitmapFactory.Options()
            //设置仅读取inJustDecodeBounds，保证快速读取数据
            options.inJustDecodeBounds = true
            BitmapFactory.decodeResource(resources,resId,options)
            options.inJustDecodeBounds = false
            options.inDensity = options.outWidth
            options.inTargetDensity = width
            return BitmapFactory.decodeResource(resources,resId,options)
        }
    }
}