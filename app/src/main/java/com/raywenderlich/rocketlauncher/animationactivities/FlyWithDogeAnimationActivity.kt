package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorSet
import android.animation.ValueAnimator

class FlyWithDogeAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    //1
    val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
    positionAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
      doge.translationY = value
    }

    //2
    val rotationAnimator = ValueAnimator.ofFloat(0f, 360f)
    rotationAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      doge.rotation = value
    }

    //3
    val animatorSet = AnimatorSet()
    animatorSet.play(positionAnimator).with(rotationAnimator)
    animatorSet.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    animatorSet.start()
  }
}
