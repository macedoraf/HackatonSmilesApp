package br.com.hacksmiles.ui.fifthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {

    lateinit var binding: FragmentFifthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthBinding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    private fun FragmentFifthBinding.setupView() {
        btNext.setOnClickListener {
            findNavController().navigate(FifthFragmentDirections.actionFifthFragmentToSixthFragment())
        }
    }
}