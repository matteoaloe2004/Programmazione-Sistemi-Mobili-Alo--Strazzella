package com.trovaparco.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trovaparco.R
import com.trovaparco.data.model.Park

class ParksAdapter(
    private var parks: List<Park>,
    private val onParkClick: (Park) -> Unit,
    private val onRemoveClick: (Park) -> Unit
) : RecyclerView.Adapter<ParksAdapter.ParkViewHolder>() {

    inner class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvParkName: TextView = itemView.findViewById(R.id.tv_park_name)
        private val btnRemoveFavorite: ImageButton = itemView.findViewById(R.id.btn_remove_favorite)

        fun bind(park: Park) {
            tvParkName.text = park.name

            itemView.setOnClickListener {
                onParkClick(park)
            }

            btnRemoveFavorite.setOnClickListener {
                onRemoveClick(park)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.bind(parks[position])
    }

    override fun getItemCount(): Int = parks.size

    fun updateParks(newParks: List<Park>) {
        parks = newParks
        notifyDataSetChanged()
    }
}
