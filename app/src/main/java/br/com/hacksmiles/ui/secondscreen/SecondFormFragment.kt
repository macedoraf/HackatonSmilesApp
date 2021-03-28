package br.com.hacksmiles.ui.secondscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.hacksmiles.databinding.FragmentSecondFormBinding

class SecondFormFragment : Fragment() {
    lateinit var binding: FragmentSecondFormBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondFormBinding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    private fun FragmentSecondFormBinding.setupView() {
        btNext.setOnClickListener { findNavController().navigate(SecondFormFragmentDirections.actionSecondFormFragmentToThirdFromFragment()) }
    }


}