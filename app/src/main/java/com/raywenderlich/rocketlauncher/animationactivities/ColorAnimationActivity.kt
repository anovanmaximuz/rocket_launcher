package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v4.content.ContextCompat
import com.raywenderlich.rocketlauncher.R

class ColorAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    //1
    val objectAnimator = ObjectAnimator.ofObject(
        frameLayout,
        "backgroundColor",
        ArgbEvaluator(),
        ContextCompat.getColor(this, R.color.background_from),
        ContextCompat.getColor(this, R.color.background_to)
    )

    // 2
    objectAnimator.repeatCount = 1
    objectAnimator.repeatMode = ValueAnimator.REVERSE

    // 3
    objectAnimator.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    objectAnimator.start()
  }
}
