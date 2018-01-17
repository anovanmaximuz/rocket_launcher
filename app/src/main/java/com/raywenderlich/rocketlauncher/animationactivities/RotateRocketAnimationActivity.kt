package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class RotateRocketAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1
    val valueAnimator = ValueAnimator.ofFloat(0f, 360f)

    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      // 2
      rocket.rotation = value
    }

    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    valueAnimator.start()
  }
}
