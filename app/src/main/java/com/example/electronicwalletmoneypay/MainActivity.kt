package com.example.electronicwalletmoneypay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.electronicwalletmoneypay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ActionViewFlipper()
    }
    private fun ActionViewFlipper() {
        val mangQuangCao = ArrayList<String>()
        mangQuangCao.add("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png")
        mangQuangCao.add("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png")
        mangQuangCao.add("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg")

        for (imageUrl in mangQuangCao) {
            val imageView = ImageView(this)
            Glide.with(this).load(imageUrl).into(imageView)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            binding.ViewFlipper.addView(imageView)
        }

        binding.ViewFlipper.flipInterval = 3000
        binding.ViewFlipper.isAutoStart = true
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        val slideOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
        binding.ViewFlipper.inAnimation = slideInAnimation
        binding.ViewFlipper.outAnimation = slideOutAnimation
    }
}