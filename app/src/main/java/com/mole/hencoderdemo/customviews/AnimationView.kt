package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class AnimationView @JvmOverloads constructor(context:Context,attrs:AttributeSet? = null):View(context, attrs){
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}