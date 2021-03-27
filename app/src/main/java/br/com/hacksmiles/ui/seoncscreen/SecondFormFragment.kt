package br.com.hacksmiles.ui.seoncscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentSecondFormBinding
import br.com.hacksmiles.ui.firstscreen.FirstFromViewModel

class SecondFormFragment : Fragment() {
    lateinit var binding: FragmentSecondFormBinding
    val viewModel = FirstFromViewModel()

    private val howManyAdapter: ArrayAdapter<String> by lazy {
        ArrayAdapter(
            this.requireContext(),
            R.layout.layout_spinner,
            viewModel.viewState.howManyList
        )
    }

    private val musicAdapter: ArrayAdapter<String> by lazy {
        ArrayAdapter(
            this.requireContext(),
            R.layout.layout_spinner,
            viewModel.viewState.musicList
        )
    }

    private val howManyListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //TODO
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            //TODO
        }
    }

    private val musicalListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //TODO
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            //TODO
        }
    }


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun FragmentSecondFormBinding.setupView() {
    }

    private fun <T> Spinner.setup(
        adapter: ArrayAdapter<T>,
        listener: AdapterView.OnItemSelectedListener
    ) {
        this.adapter = adapter
        this.onItemSelectedListener = listener
    }
}