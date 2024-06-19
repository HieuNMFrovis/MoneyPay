package com.example.electronicwalletmoneypay.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        actionViewFlipper()
    }
    private fun actionViewFlipper() {
        val mangQuangCao = ArrayList<String>()
        mangQuangCao.add(
            "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png"
        )
        mangQuangCao.add(
            "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png"
        )
        mangQuangCao.add(
            "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"
        )

        for (imageUrl in mangQuangCao) {
            val imageView = ImageView(requireActivity())
            Glide.with(requireActivity()).load(imageUrl).into(imageView)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            binding.ViewFlipper.addView(imageView)
        }

        binding.ViewFlipper.flipInterval = 3000
        binding.ViewFlipper.isAutoStart = true
        val slideInAnimation = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_in_right)
        val slideOutAnimation = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_out_right)
        binding.ViewFlipper.inAnimation = slideInAnimation
        binding.ViewFlipper.outAnimation = slideOutAnimation
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.card1.setOnClickListener {
            val intent = Intent(requireContext(), RechargeActivity::class.java)
            startActivity(intent)
        }
        binding.card4.setOnClickListener {
            val intent = Intent(requireContext(), WithdrawMoneyActivity::class.java)
            startActivity(intent)
        }

    }
}