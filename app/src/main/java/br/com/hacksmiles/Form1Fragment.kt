package br.com.hacksmiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SpinnerAdapter
import androidx.fragment.app.Fragment
import br.com.hacksmiles.databinding.FragmentForm1Binding

class Form1Fragment : Fragment() {
    lateinit var binding: FragmentForm1Binding
    val viewModel = Form1ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForm1Binding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun FragmentForm1Binding.setupView() {
        this.viewState = viewModel.viewState
    }
}