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
import br.com.hacksmiles.ui.MainActivity

class ThirdFromFragment : Fragment() {

    lateinit var binding: FragmentThirdFormBinding
    lateinit var viewModel: ThirdFromViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ThirdFromViewModel((activity as MainActivity).repository)
    }

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
        setupRecyclerView()
        setupAdapter()
        this.viewState = viewModel.viewState
    }

    private fun FragmentThirdFormBinding.setupRecyclerView() {
        rvDestinies.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun FragmentThirdFormBinding.setupAdapter() {
        rvDestinies.adapter = object : DataBindingAdapter() {
            override fun getLayoutId(): Int = R.layout.layout_destiny_item
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchData()
    }
}