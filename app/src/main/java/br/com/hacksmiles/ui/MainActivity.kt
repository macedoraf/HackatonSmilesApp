package br.com.hacksmiles.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.hacksmiles.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavView.background = null
        bottomNavView.menu.getItem(2).isEnabled = false

    }
}