package com.artemka337.airtimer228.breathSession.viewModel

import android.os.CountDownTimer
import com.artemka337.airtimer228.breathSession.parameters
import com.artemka337.airtimer228.breathSession.view.BreathFragment

class breathViewModel {
    val parameter = parameters(
        10,
        2,
        1,
        1,
        3
    )

    val currentParameters = parameter.copy()

    var listener: BreathFragment? = null

    var timer: CountDownTimer? = null

    fun startSession() {
        timer = object : CountDownTimer(
            parameter.sessionLength * 1000L,
            1000L
        ) {
            override fun onTick(p0: Long) {
                updateSession()
                listner?.onChange(currentParameters)
            }
                override fun onFinish(){

                }
        }
    }

    fun updateSession(){
        currentParameters.sessionLength -= 1

        if (currentParameters.inhale > 0){
            currentParameters.inhale -= 1
        } else if (currentParameters.sessionDelay1 > 0){
            currentParameters.sessionDelay1 -= 1
        } else if (currentParameters.exhale > 0){
            currentParameters.exhale -= 1
        } else if (currentParameters.sessionDelay2 > 0){
            currentParameters.sessionDelay2 -= 1
        }
        if(currentParameters.sessionDelay2 ==0){
            currentParameters.inhale = parameter.inhale
            currentParameters.exhale = parameter.inhale
            currentParameters.sessionDelay1 = parameter.sessionDelay1
            currentParameters.sessionDelay2 = parameter.sessionDelay2
        }

        currentParameters.inhale -= 1
    }

}