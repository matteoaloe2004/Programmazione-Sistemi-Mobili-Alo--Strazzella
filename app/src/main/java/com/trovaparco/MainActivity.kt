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

        // Ottieni l’istanza del repository
        val apiKey = "AIzaSyBhHTO8zvllwkHhsW0_JlMVoAJ2ewbHNFU" // metti qui la tua chiave API reale
        val repository = ParkRepository.getInstance(apiKey)

        // Crea la factory passando il repository
        val factory = MapViewModelFactory(repository)

        // Inizializza il ViewModel con la factory
        viewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)

        // Inizializza la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Inizializza il DrawerLayout e NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        // Osserva i parchi vicini e aggiorna il menu
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

        // Osserva la posizione corrente e aggiorna i parchi
        viewModel.getCurrentLocation().observe(this) { location ->
            location?.let {
                viewModel.fetchNearbyParks(it.latitude, it.longitude)
            }
        }

        // Apri il drawer al click sull’icona
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}
