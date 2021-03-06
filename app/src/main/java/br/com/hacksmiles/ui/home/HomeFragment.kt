package br.com.hacksmiles.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.FragmentHomeBinding
import br.com.hacksmiles.ui.DataBindingAdapter
import br.com.hacksmiles.ui.MainActivity


class HomeFragment : Fragment() {

    companion object{
        open var showRecyclerView: Boolean = false
    }
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel
    private val adapter by lazy {
        object : DataBindingAdapter() {
            override var onClick: ((position: Int) -> Unit)? = ::navigateToDetailScreen
            override fun getLayoutId(): Int = R.layout.trip_progress_item
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HomeViewModel((activity as MainActivity).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.setupView()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.viewState.plannedTrips.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.fetchData()
    }

    private fun FragmentHomeBinding.setupView() {
        setupRecyclerView()
        setupAdapter()
        this.viewState = viewModel.viewState
    }

    private fun FragmentHomeBinding.setupAdapter() {
        rvHome.adapter = adapter
    }

    private fun navigateToDetailScreen(position: Int) {
        viewModel.viewState.plannedTrips.value?.get(position)
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToTripDetailFragment()
        )
    }

    private fun FragmentHomeBinding.setupRecyclerView() {
        if (showRecyclerView) {
            rvHome.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            rvHome.visibility = View.VISIBLE
        } else {
            rvHome.visibility = View.GONE
        }
    }
}