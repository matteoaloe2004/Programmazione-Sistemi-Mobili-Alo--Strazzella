package com.trovaparco.data.local

import android.content.Context
import com.trovaparco.data.model.Park
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class FavoritesStorage(context: Context) {

    companion object {
        private const val PREFS_NAME = "favorites_prefs"
        private const val KEY_FAVORITES = "favorite_parks"
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val moshi = Moshi.Builder().build()
    private val listType = Types.newParameterizedType(List::class.java, Park::class.java)
    private val adapter = moshi.adapter<List<Park>>(listType)

    fun saveFavorites(parks: List<Park>) {
        val json = adapter.toJson(parks)
        prefs.edit().putString(KEY_FAVORITES, json).apply()
    }

    fun loadFavorites(): List<Park> {
        val json = prefs.getString(KEY_FAVORITES, null) ?: return emptyList()
        return adapter.fromJson(json) ?: emptyList()
    }
}
