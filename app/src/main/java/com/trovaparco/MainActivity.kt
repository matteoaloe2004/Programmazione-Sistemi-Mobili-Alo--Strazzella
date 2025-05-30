package com.trovaparco

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import com.trovaparco.data.repository.ParkRepository
import com.trovaparco.viewmodel.MapViewModel
import com.trovaparco.viewmodel.MapViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // API key di Google
        val googleApiKey = "AIzaSyBhHTO8zvllwkHhsW0_JlMVoAJ2ewbHNFU"
        // API key per il meteo
        val weatherApiKey = "2ffc03a059d5b3528a70c81c73402e02"

        // Passa entrambe le chiavi al repository
        val repository = ParkRepository.getInstance(googleApiKey, weatherApiKey)

        val factory = MapViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        viewModel.nearbyParks.observe(this) { parks ->
            val menu = navigationView.menu
            val group = menu.findItem(R.id.nearby_parks_group)?.subMenu
            group?.clear()

            if (parks.isEmpty()) {
                group?.add(Menu.NONE, Menu.NONE, Menu.NONE, "Nessun parco nelle vicinanze")
                    ?.setEnabled(false)
            } else {
                parks.forEach { park ->
                    group?.add(Menu.NONE, Menu.NONE, Menu.NONE, park.name)?.apply {
                        setIcon(R.drawable.ic_menu)
                        setOnMenuItemClickListener {
                            val bundle = Bundle().apply {
                                putString("parkId", park.id)
                            }
                            val navController = findNavController(R.id.nav_host_fragment)
                            navController.navigate(R.id.parkDetailFragment, bundle)
                            drawerLayout.closeDrawer(GravityCompat.START)
                            true
                        }
                    }
                }
            }
        }

        viewModel.getCurrentLocation().observe(this) { location ->
            location?.let {
                viewModel.fetchNearbyParks(it.latitude, it.longitude)
            }
        }

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}
