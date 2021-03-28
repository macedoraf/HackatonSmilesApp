package br.com.hacksmiles.ui.thridscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentThirdFormBinding
import br.com.hacksmiles.ui.DataBindingAdapter

class ThirdFromFragment : Fragment() {

    lateinit var binding: FragmentThirdFormBinding
    val viewState = ThirdFromViewState()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdFormBinding.inflate(inflater)
        binding.setupView()
        return binding.root
    }

    private fun FragmentThirdFormBinding.setupView() {
        rvDestinies.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        rvDestinies.adapter = object : DataBindingAdapter() {
            override fun getLayoutId(): Int = R.layout.layout_destiny_item
        }

        this.viewState = this@ThirdFromFragment.viewState
    }

    override fun onStart() {
        super.onStart()
        viewState.destinies.value = listOf(0, 0, 0, 0, 0)
    }
}