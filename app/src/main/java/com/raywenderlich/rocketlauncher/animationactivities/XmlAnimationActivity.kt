package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import com.raywenderlich.rocketlauncher.R

class XmlAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1
    val rocketAnimatorSet = AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink) as AnimatorSet
    // 2
    rocketAnimatorSet.setTarget(rocket)

    // 3
    val dogeAnimatorSet = AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink) as AnimatorSet
    // 4
    dogeAnimatorSet.setTarget(doge)

    // 5
    val bothAnimatorSet = AnimatorSet()
    bothAnimatorSet.playTogether(rocketAnimatorSet, dogeAnimatorSet)
    // 6
    bothAnimatorSet.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    bothAnimatorSet.start()
  }
}
