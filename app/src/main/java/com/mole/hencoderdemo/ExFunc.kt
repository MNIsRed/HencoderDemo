package com.mole.hencoderdemo

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue

val Float.dp : Float
get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this, Resources.getSystem().displayMetrics)

val Int.dp : Float
    get() = this.toFloat().dp

val String.color : Int
get() = Color.parseColor(this)