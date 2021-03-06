package br.com.hacksmiles.ui.firstscreen

import android.os.Bundle
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
import br.com.hacksmiles.R
import br.com.hacksmiles.data.nome
import br.com.hacksmiles.databinding.FragmentForm1Binding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.util.*

const val FORCE_GO_NEXT = true

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

        btSelectDate.setOnClickListener {
            val dateRangePicker =
                MaterialDatePicker.Builder.dateRangePicker()
                    .setTitleText("Selecionar datas das ferias")
                    .setSelection(
                        androidx.core.util.Pair(
                            MaterialDatePicker.thisMonthInUtcMilliseconds(),
                            MaterialDatePicker.todayInUtcMilliseconds()
                        )
                    )
                    .build()

            dateRangePicker.show(requireActivity().supportFragmentManager, "")
        }

        btNext.setOnClickListener {
            viewModel.viewState.name = etName.text.toString()
            nome = viewModel.viewState.name
            viewModel.viewState.birthdayDate = calendarBirthDay.text.toString()
            val result = viewModel.validateForm()
            if (result.first) {
                findNavController().navigate(
                    FirstFormFragmentDirections.actionForm1FragmentToThirdFromFragment(
                        result.second
                    )
                )
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

    private fun showDialog() {
        val locale: Locale = resources.configuration.locale
        Locale.setDefault(locale)
        val dateRangePicker =
            MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Selecionar datas das ferias")
                .setSelection(
                    androidx.core.util.Pair(
                        MaterialDatePicker.thisMonthInUtcMilliseconds(),
                        MaterialDatePicker.todayInUtcMilliseconds()
                    )
                )
                .build().apply {
                    addOnPositiveButtonClickListener {

                    }
                }

        dateRangePicker.show(requireActivity().supportFragmentManager, "")
    }

}


