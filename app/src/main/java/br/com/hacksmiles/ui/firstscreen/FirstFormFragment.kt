package br.com.hacksmiles.ui.firstscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentForm1Binding
import br.com.hacksmiles.ui.climate.ClimateAdapter
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

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


    private fun resetAllSelected() {
        binding.imgSnow.background = null
        binding.imgBeach.background = null
        binding.imgCity.background = null
        binding.imgMountains.background = null
    }

    private fun setBorder(imageVIew: AppCompatImageView) {
        imageVIew.background = ContextCompat.getDrawable(
            this@FirstFormFragment.requireContext(),
            R.drawable.background_border
        )
    }

    private fun FragmentForm1Binding.setOnClickListeners() {
        imgSnow.setOnClickListener {
            resetAllSelected()
            selectPreference("Neve")
            setBorder(binding.imgSnow)

        }
        imgBeach.setOnClickListener {
            resetAllSelected()
            setBorder(binding.imgBeach)
            selectPreference("Praia")
        }
        imgCity.setOnClickListener {
            resetAllSelected()
            setBorder(binding.imgCity)
            selectPreference("Cidade")
        }
        imgMountains.setOnClickListener {
            resetAllSelected()
            setBorder(binding.imgMountains)
            selectPreference("Montanha")
        }

        btNext.setOnClickListener {
            viewModel.viewState.name = etName.text.toString()
            viewModel.viewState.birthdayDate = calendarBirthDay.text.toString()
            if (viewModel.validateForm()) {
                findNavController().navigate(FirstFormFragmentDirections.actionForm1FragmentToSecondFormFragment())
            } else {
                Snackbar.make(
                    this.root,
                    "Por favor, preencha todos os campos para que possamos preparar sua viagem.",
                    Snackbar.LENGTH_LONG
                ).show()
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

}


