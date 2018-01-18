package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.util.Log
import android.view.animation.LinearInterpolator
import java.util.*

class RotateRocketAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    val corner = 360 / 38 //corner for point
    val randPosition = corner * Random().nextInt(38) //random point
    val MIN = 5 //min rotation
    val MAX = 9 //max rotation - greather than 9 can make out of memory
    val TIME_IN_WHEEL: Long = 1000  //time in one rotation
    val randRotation = MIN + Random().nextInt(MAX - MIN) //random rotation
    var truePosition = randRotation * 360 + randPosition
    while (getTruePosition(truePosition) == 10) {
      truePosition = randRotation * 360 + randPosition
    }
    val totalTime = TIME_IN_WHEEL * randRotation + TIME_IN_WHEEL / 360 * randPosition
    Log.d("ROULETTE_ACTION", "randPosition : " + randPosition
            + " randRotation : " + randRotation
            + " totalTime : " + totalTime
            + " truePosition : " + truePosition
            + " chocolate : " + getTruePosition(truePosition).toString())

    // 1
    val valueAnimator = ValueAnimator.ofFloat(0f, truePosition.toFloat())

    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      // 2
      ic_roulette.rotation = value
    }

    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = totalTime //BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
    valueAnimator.start()
  }

  fun getTruePosition(result: Int): Int{
    val pos = result % 360
    if(pos<=30){
      return 10
    }else if(pos>330 && pos<=360){
      return 10
    }else if(pos>30 && pos<=90){
      return 1
    }else if(pos>90 && pos<=150){
      return 4
    }else if(pos>150 && pos<=210){
      return 2
    }else if(pos>210 && pos<=270){
      return 5
    }else if(pos>270 && pos<=330){
      return 3
    }else{
      return 0
    }
  }
}
