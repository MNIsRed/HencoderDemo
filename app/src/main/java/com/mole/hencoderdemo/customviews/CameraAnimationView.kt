package com.mole.hencoderdemo.customviews

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.mole.hencoderdemo.R
import com.mole.hencoderdemo.dp
import com.mole.hencoderdemo.utils.BitmapUtils

/**
 * 操作多个属性，对应AnimatorSet
 */
private val IMAGE_WIDTH = 100.dp

class CameraAnimationView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private val paint = Paint()
    private val camera: Camera = Camera()
    private val bitmap: Bitmap
    var topDegree: Float = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomDegree: Float = 0f
        set(value) {
            field = value
            invalidate()
        }
    var imageRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
        bitmap = BitmapUtils.getBitmap(resources, R.drawable.avatar_rengwuxian, IMAGE_WIDTH.toInt())
    }

    override fun onDraw(canvas: Canvas) {
        val leftPadding = (width - IMAGE_WIDTH) / 2
        //裁切会改变canvas，需要save配合restore还原canvas
        canvas.withSave {
            //第七步，将图片位移回指定地点
            canvas.translate(leftPadding + IMAGE_WIDTH / 2, leftPadding + IMAGE_WIDTH / 2)
            //第六步，图片旋转回来，使得看上去像是斜着切的
            canvas.rotate(-imageRotation)
            //由于camera的rotate是叠加的，所以需要每次设置后重置，避免重绘导致角度不正确
            camera.save()
            camera.rotate(topDegree, 0f, 0f)
            //第五步，对裁剪完后的图片使用camera进行三维上的x轴的旋转
            camera.applyToCanvas(canvas)
            camera.restore()
            //第四步，图片旋转后需要裁切范围变大，保留上半部分，所以bottom是0，并且需要注意y轴正方向，所以这里top是-IMAGE_WIDTH
            canvas.clipRect(-IMAGE_WIDTH, -IMAGE_WIDTH, IMAGE_WIDTH, 0f)
            //第三步，图片旋转30度
            canvas.rotate(imageRotation)
            //第二步，向原点处位移，使图片中心位于原点
            canvas.translate(-leftPadding - IMAGE_WIDTH / 2, -leftPadding - IMAGE_WIDTH / 2)
            //第一步，在指定位置绘制图片
            canvas.drawBitmap(bitmap, leftPadding, leftPadding, paint)
        }
        //开始准备绘制下半部分

        //将图片位移回指定地点
        canvas.translate(leftPadding + IMAGE_WIDTH / 2, leftPadding + IMAGE_WIDTH / 2)
        //图片旋转回来，使得看上去像是斜着切的
        canvas.rotate(-imageRotation)
        camera.save()
        camera.rotate(bottomDegree, 0f, 0f)
        //第五步，对裁剪完后的图片使用camera进行三维上的x轴的旋转
        camera.applyToCanvas(canvas)
        camera.restore()
        //第四步，图片旋转后需要裁切范围变大，但依旧是保留下半部分，所以top仍然是0
        canvas.clipRect(-IMAGE_WIDTH, 0f, IMAGE_WIDTH, IMAGE_WIDTH)
        //第三步，图片旋转30度
        canvas.rotate(imageRotation)
        //第二步，向原点处位移，使图片中心位于原点
        canvas.translate(-leftPadding - IMAGE_WIDTH / 2, -leftPadding - IMAGE_WIDTH / 2)
        //第一步，在指定位置绘制图片
        canvas.drawBitmap(bitmap, leftPadding, leftPadding, paint)
    }
}