package com.mole.hencoderdemo.fragment

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.PointF
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mole.hencoderdemo.R
import com.mole.hencoderdemo.customviews.*
import com.mole.hencoderdemo.dp

class AnimationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scaleView = view.findViewById<ScaleAnimationView>(R.id.scale_view)
        val frame1 = Keyframe.ofFloat(0f, 50.dp)
        val frame2 = Keyframe.ofFloat(0.3f, 55.dp)
        val frame3 = Keyframe.ofFloat(0.6f, 62.dp)
        val frame4 = Keyframe.ofFloat(0.8f, 70.dp)
        val frame5 = Keyframe.ofFloat(1f, 100.dp)
        ObjectAnimator.ofPropertyValuesHolder(
            scaleView,
            PropertyValuesHolder.ofKeyframe("radius", frame1, frame2, frame3, frame4, frame5)
        ).apply {
            duration = 5000
            startDelay = 1000
            start()
        }

        val translateView = view.findViewById<TranslateAnimationView>(R.id.translate_view)
        ObjectAnimator.ofObject(translateView, "pointF", PointFTypeEvaluator(), PointF(100f, 200f))
            .apply {
                duration = 2000
                startDelay = 1000
                start()
            }

        val cameraView = view.findViewById<CameraAnimationView>(R.id.camera_view)
        val topAnimation = ObjectAnimator.ofFloat(cameraView, "topDegree", -30f)
        val bottomAnimation = ObjectAnimator.ofFloat(cameraView, "bottomDegree", 30f)
        val rotationAnimation = ObjectAnimator.ofFloat(cameraView, "imageRotation", 270f)
        AnimatorSet().apply {
            playSequentially(bottomAnimation, rotationAnimation, topAnimation)
            duration = 2000
            startDelay = 1000
            start()
        }

        val textView = view.findViewById<TextAnimationView>(R.id.text_view)
        ObjectAnimator.ofObject(textView, "showText", TextTypeEvaluator(), "new Province").apply {
            duration = 4000
            startDelay = 1000
            start()
        }
    }
}