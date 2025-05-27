package com.trovaparco.ui.detail

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ParkDetailFragmentArgs(
  public val parkId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("parkId", this.parkId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("parkId", this.parkId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ParkDetailFragmentArgs {
      bundle.setClassLoader(ParkDetailFragmentArgs::class.java.classLoader)
      val __parkId : String?
      if (bundle.containsKey("parkId")) {
        __parkId = bundle.getString("parkId")
        if (__parkId == null) {
          throw IllegalArgumentException("Argument \"parkId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"parkId\" is missing and does not have an android:defaultValue")
      }
      return ParkDetailFragmentArgs(__parkId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ParkDetailFragmentArgs {
      val __parkId : String?
      if (savedStateHandle.contains("parkId")) {
        __parkId = savedStateHandle["parkId"]
        if (__parkId == null) {
          throw IllegalArgumentException("Argument \"parkId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"parkId\" is missing and does not have an android:defaultValue")
      }
      return ParkDetailFragmentArgs(__parkId)
    }
  }
}
