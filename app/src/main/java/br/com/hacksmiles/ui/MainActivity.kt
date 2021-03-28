package br.com.hacksmiles.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.*
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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
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
                        ProfileFragmentDirections.actionProfileFragmentToHomeFragment(),
                        NavOptions.Builder().setPopUpTo(R.id.profileFragment, true).build()
                    )
                }
                R.id.profile -> {
                    findNavController(R.id.nav_host_fragment).navigate(
                        HomeFragmentDirections.actionHomeFragmentToProfileFragment(),
                        NavOptions.Builder().setPopUpTo(R.id.homeFragment, true).build()
                    )
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.setDisplayShowHomeEnabled(false)
                    supportActionBar?.setDisplayShowTitleEnabled(true)
                    bottomNavigationView.menu[0].isEnabled = false
                    bottomNavigationView.menu[2].isEnabled = true
                    bottomNavigationView.background = null
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE
                }

                R.id.profileFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.setDisplayShowHomeEnabled(false)
                    supportActionBar?.setDisplayShowTitleEnabled(true)
                    bottomNavigationView.menu[0].isEnabled = true
                    bottomNavigationView.menu[2].isEnabled = false
                    bottomNavigationView.background = null
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.GONE
                }
                else -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    supportActionBar?.setDisplayShowHomeEnabled(true)
                    supportActionBar?.setDisplayShowTitleEnabled(false)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }
}