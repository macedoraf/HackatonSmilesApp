package br.com.hacksmiles.ui.firstscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentForm1Binding
import br.com.hacksmiles.ui.climate.ClimateAdapter

class FirstFormFragment : Fragment() {
    lateinit var binding: FragmentForm1Binding
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

    private val climateAdapter: ClimateAdapter by lazy { ClimateAdapter() }

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
        binding = FragmentForm1Binding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchData()
    }

    private fun FragmentForm1Binding.setupView() {
        this.viewState = viewModel.viewState
        this.spMusicTaste.setup(musicAdapter, musicalListener)
        this.spHowManyPeople.setup(howManyAdapter, howManyListener)
        this.rvClimaticSelector.setup()
        this.btNext.setOnClickListener {
            findNavController().navigate(FirstFormFragmentDirections.actionForm1FragmentToSecondFormFragment())
        }
    }

    private fun <T> Spinner.setup(
        adapter: ArrayAdapter<T>,
        listener: AdapterView.OnItemSelectedListener
    ) {
        this.adapter = adapter
        this.onItemSelectedListener = listener
    }

    private fun RecyclerView.setup() {
        adapter = climateAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}


