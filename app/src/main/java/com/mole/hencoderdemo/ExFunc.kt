package com.mole.hencoderdemo

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue

val Float.px : Float
get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this, Resources.getSystem().displayMetrics)

val String.color : Int
get() = Color.parseColor(this)