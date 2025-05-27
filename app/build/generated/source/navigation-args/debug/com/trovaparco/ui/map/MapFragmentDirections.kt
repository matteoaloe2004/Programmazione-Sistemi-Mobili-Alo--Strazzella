package com.trovaparco.ui.map

import android.os.Bundle
import androidx.navigation.NavDirections
import com.trovaparco.R
import kotlin.Int
import kotlin.String

public class MapFragmentDirections private constructor() {
  private data class ActionMapFragmentToParkDetailFragment(
    public val parkId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_mapFragment_to_parkDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("parkId", this.parkId)
        return result
      }
  }

  public companion object {
    public fun actionMapFragmentToParkDetailFragment(parkId: String): NavDirections =
        ActionMapFragmentToParkDetailFragment(parkId)
  }
}
