package com.example.nesion.presentation.opening

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.fragment.findNavController
import com.example.nesion.R
import com.example.nesion.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

//    val timerTotal = 5000L // 5 scd
//    lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.root.apply {
            this@SplashFragment

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
                    val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                    findNavController().navigate(action)
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


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        timer = object : CountDownTimer(timerTotal, 1000) {
//            override fun onTick(p0: Long) {
//                val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
//                findNavController().navigate(action)
//            }
//
//            override fun onFinish() {
//            }
//        }
//    }
}