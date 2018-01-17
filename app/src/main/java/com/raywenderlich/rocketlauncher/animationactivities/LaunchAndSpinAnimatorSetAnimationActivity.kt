package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator

class LaunchAndSpinAnimatorSetAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1
    val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

    // 2
    positionAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
    }

    // 3
    val rotationAnimator = ObjectAnimator.ofFloat(rocket, "rotation", 0f, 180f)
    // 4
    val animatorSet = AnimatorSet()
    // 5
    animatorSet.play(positionAnimator).with(rotationAnimator)
    // 6
    animatorSet.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    animatorSet.start()
  }
}
