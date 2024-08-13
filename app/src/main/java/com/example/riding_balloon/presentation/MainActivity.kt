package com.example.riding_balloon.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.riding_balloon.R
import com.example.riding_balloon.databinding.ActivityMainBinding
import com.example.riding_balloon.presentation.home.HomeFragmentDirections

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        setBottomNavigation()
        initButton()
    }

    private fun setBottomNavigation() = with(binding) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationMain.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_my_page -> {
                    bottomNavigationMain.visibility = View.VISIBLE
                    layoutToolbarMain.root.visibility = View.VISIBLE
                }

                else -> {
                    bottomNavigationMain.visibility = View.GONE
                    layoutToolbarMain.root.visibility = View.GONE
                }
            }
        }
    }

    private fun initButton() = with(binding) {
        layoutToolbarMain.btnToolbarTravelSpot.setOnClickListener {
            val action = HomeFragmentDirections.actionGlobalTravelSpotDetail()
            findNavController(R.id.container_main).navigate(action)
        }
        layoutToolbarMain.btnToolbarVideo.setOnClickListener {
            val action = HomeFragmentDirections.actionGlobalVideoDetail()
            findNavController(R.id.container_main).navigate(action)
        }
    }
}