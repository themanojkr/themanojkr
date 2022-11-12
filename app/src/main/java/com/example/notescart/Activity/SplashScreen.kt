package com.example.notescart.Activity

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notescart.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
animation_view.addAnimatorListener(object :Animator.AnimatorListener{
    override fun onAnimationStart(p0: Animator) {

    }

    override fun onAnimationEnd(p0: Animator) {
       startActivity(Intent(this@SplashScreen,MainActivity::class.java))
        finish()
    }

    override fun onAnimationCancel(p0: Animator) {

    }

    override fun onAnimationRepeat(p0: Animator) {

    }

})
    }
}