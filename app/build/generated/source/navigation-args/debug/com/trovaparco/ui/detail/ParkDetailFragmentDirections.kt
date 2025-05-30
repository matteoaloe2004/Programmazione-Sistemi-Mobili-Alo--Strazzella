package com.trovaparco.ui.detail

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.trovaparco.R

public class ParkDetailFragmentDirections private constructor() {
  public companion object {
    public fun actionParkDetailFragmentToMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_parkDetailFragment_to_mapFragment)
  }
}
