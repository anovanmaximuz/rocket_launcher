package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ObjectAnimator

class LaunchRocketObjectAnimatorAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1
    val objectAnimator = ObjectAnimator.ofFloat(rocket, "translationY", 0f, -screenHeight)

    // 2
    objectAnimator.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    objectAnimator.start()
  }
}
