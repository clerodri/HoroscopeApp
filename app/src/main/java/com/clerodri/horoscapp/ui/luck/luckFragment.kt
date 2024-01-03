package com.clerodri.horoscapp.ui.luck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clerodri.horoscapp.R
import com.clerodri.horoscapp.databinding.FragmentHoroscopeBinding
import com.clerodri.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class luckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}