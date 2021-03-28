package br.com.hacksmiles.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import br.com.hacksmiles.R
import br.com.hacksmiles.databinding.ActivityMainBinding
import br.com.hacksmiles.ui.home.HomeFragmentDirections
import br.com.hacksmiles.ui.profile.ProfileFragmentDirections
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
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    findNavController(R.id.nav_host_fragment).navigate(
                        ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                    )
                }
                R.id.profile -> {
                    findNavController(R.id.nav_host_fragment).navigate(
                        HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                    )
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomNavigationView.menu[0].isEnabled = false
                    bottomNavigationView.menu[2].isEnabled = true
                    bottomNavigationView.background = null
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE
                }

                R.id.profileFragment -> {
                    bottomNavigationView.menu[0].isEnabled = true
                    bottomNavigationView.menu[2].isEnabled = false
                    bottomNavigationView.background = null
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.GONE
                }
                else -> {
                    bottomAppBar.visibility = View.GONE
                    fab.visibility = View.GONE
                }
            }
        }
    }

    private fun ActivityMainBinding.setupView() {
        fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(
                HomeFragmentDirections.actionHomeFragmentToForm1Fragment()
            )
        }

    }
}