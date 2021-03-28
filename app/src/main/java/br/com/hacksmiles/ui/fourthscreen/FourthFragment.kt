package br.com.hacksmiles.ui.fourthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.hacksmiles.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    private fun FragmentFourthBinding.setupView() {
        btnNext.setOnClickListener { findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment()) }
    }
}