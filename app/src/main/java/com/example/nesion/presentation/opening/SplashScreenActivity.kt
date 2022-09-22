package com.example.nesion.presentation.opening

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.nesion.R
import com.example.nesion.databinding.ActivitySplashScreenBinding
import com.example.nesion.presentation.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.apply {
            this.startLayoutAnimation()

            addTransitionListener(object : MotionLayout.TransitionListener {
                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int
                ) {
                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                }

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float
                ) {
                }

            })
        }
    }
}