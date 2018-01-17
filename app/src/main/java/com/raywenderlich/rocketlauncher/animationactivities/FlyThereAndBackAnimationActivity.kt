package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator

class FlyThereAndBackAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1
    val animator = ValueAnimator.ofFloat(0f, -screenHeight)

    animator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
      doge.translationY = value
    }

    // 2
    animator.repeatMode = ValueAnimator.REVERSE
    // 3
    animator.repeatCount = 3

    // 4
    animator.duration = 500L
    animator.start()
  }
}
