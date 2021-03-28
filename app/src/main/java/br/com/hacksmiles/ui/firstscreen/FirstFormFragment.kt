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


    private val climateAdapter: ClimateAdapter by lazy { ClimateAdapter() }

    private val howManyListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            viewModel.viewState.howMany = viewModel.viewState.howManyList[position].toInt()
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
        this.spHowManyPeople.setup(howManyAdapter, howManyListener)
        setOnClickListeners()
    }

    private fun FragmentForm1Binding.setOnClickListeners() {
        imgSnow.setOnClickListener { selectPreference("Neve") }
        imgBeach.setOnClickListener { selectPreference("Praia") }
        imgCity.setOnClickListener { selectPreference("Cidade") }
        imgMountains.setOnClickListener { selectPreference("Montanha") }

        btNext.setOnClickListener {
            viewModel.viewState.name = etName.text.toString()
            viewModel.viewState.birthdayDate = calendarBirthDay.text.toString()
            if (viewModel.validateForm()) {
                findNavController().navigate(FirstFormFragmentDirections.actionForm1FragmentToSecondFormFragment())
            }
        }
    }

    private fun <T> Spinner.setup(
        adapter: ArrayAdapter<T>,
        listener: AdapterView.OnItemSelectedListener
    ) {
        this.adapter = adapter
        this.onItemSelectedListener = listener
    }

    private fun selectPreference(tag: String) {
        viewModel.viewState.selectedClimate = tag
    }

    private fun RecyclerView.setup() {
        adapter = climateAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}


