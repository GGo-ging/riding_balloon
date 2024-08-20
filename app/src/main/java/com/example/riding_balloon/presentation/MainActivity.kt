package com.example.riding_balloon.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.riding_balloon.R
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.databinding.ActivityMainBinding
import com.example.riding_balloon.presentation.home.HomeFragmentDirections
import com.example.riding_balloon.presentation.travelspotdetail.TravelSpotDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val travelSpotItem by lazy { TravelSpotManager.getFirstItem() }

    val tsdViewModel by viewModels<TravelSpotDetailViewModel>()

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
        val videosMap = mapOf(
            0 to "RSv0K4hQyV8",
            1 to "YJmu2JuDdZw",
            2 to "XSU0CsElmVA",
            3 to "WMjYjWufHwg",
            4 to "h-XCpon8B5k",
            5 to "hzjgHEF1-i0",
            6 to "ZsgG9EOV4eE",
        )

        layoutToolbarMain.btnToolbarTravelSpot.setOnClickListener {
            val action = HomeFragmentDirections.actionGlobalTravelSpotDetail(travelSpotItem)
            findNavController(R.id.container_main).navigate(action)
        }
        layoutToolbarMain.btnToolbarVideo.setOnClickListener {
            val randomIndex = (0..6).random()
            val randomVideoId = videosMap[randomIndex] ?: "RSv0K4hQyV8"

            val action = HomeFragmentDirections.actionGlobalVideoDetail(randomVideoId)
            findNavController(R.id.container_main).navigate(action)
        }
    }

    private fun sendTravelSpotItem() {
        val action = HomeFragmentDirections.actionGlobalTravelSpotDetail(travelSpotItem)
        findNavController(R.id.container_main).navigate(action)
    }
}