package br.com.hacksmiles.ui.fourthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.hacksmiles.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    lateinit var binding: FragmentFourthBinding


    private val args = navArgs<FourthFragmentArgs>()

    private val viewModel = FourthViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.value.destiny.run {
            viewModel.viewState.destiny.value = this
        }
    }


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
        this.viewState = viewModel.viewState
        btnNext.setOnClickListener { findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToSixthFragment2()) }

    }
}