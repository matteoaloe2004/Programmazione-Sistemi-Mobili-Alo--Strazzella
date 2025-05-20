package com.trovaparco

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import com.trovaparco.viewmodel.MapViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

        // Inizializza la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Inizializza il DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        // Osserva i parchi vicini
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
                            // Use the bundle approach instead of SafeArgs
                            val bundle = Bundle().apply {
                                putString("parkId", park.id)
                            }
                            val navController = findNavController(R.id.nav_host_fragment)
                            navController.navigate(
                                R.id.parkDetailFragment,
                                bundle
                            )
                            drawerLayout.closeDrawer(GravityCompat.START)
                            true
                        }
                    }
                }
            }
        }

        // Aggiorna i parchi quando cambia la posizione
        viewModel.getCurrentLocation().observe(this) { location ->
            location?.let { currentLocation ->
                viewModel.fetchNearbyParks(currentLocation.latitude, currentLocation.longitude)
            }
        }

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}