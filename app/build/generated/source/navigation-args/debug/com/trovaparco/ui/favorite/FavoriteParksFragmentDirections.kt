package com.trovaparco.ui.favorite

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.trovaparco.R
import kotlin.Int
import kotlin.String

public class FavoriteParksFragmentDirections private constructor() {
  private data class ActionFavoriteParksFragmentToParkDetailFragment(
    public val parkId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_favoriteParksFragment_to_parkDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("parkId", this.parkId)
        return result
      }
  }

  public companion object {
    public fun actionFavoriteParksFragmentToMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_favoriteParksFragment_to_mapFragment)

    public fun actionFavoriteParksFragmentToParkDetailFragment(parkId: String): NavDirections =
        ActionFavoriteParksFragmentToParkDetailFragment(parkId)
  }
}
