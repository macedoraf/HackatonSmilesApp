package br.com.hacksmiles.ui.sixthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentSixthBinding

class SixthFragment : Fragment() {
    lateinit var binding: FragmentSixthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSixthBinding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    private fun FragmentSixthBinding.setupView() {
        btnGoHome.setOnClickListener {
            findNavController().navigate(SixthFragmentDirections.actionSixthFragmentToHomeFragment())
        }
    }
}