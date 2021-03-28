package br.com.hacksmiles.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.ActivityMainBinding
import br.com.hacksmiles.ui.home.HomeFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setupView()
    }

    override fun onStart() {
        super.onStart()
        binding.setupBottomAppBar()
    }

    private fun ActivityMainBinding.setupBottomAppBar() {
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE
                }
                else -> {
                    bottomAppBar.visibility = View.GONE
                    fab.visibility = View.GONE
                }
            }
        }
    }

    private fun ActivityMainBinding.setupView() {
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(
                HomeFragmentDirections.actionHomeFragmentToForm1Fragment()
            )
        }

    }
}