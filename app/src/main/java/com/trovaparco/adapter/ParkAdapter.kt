package com.trovaparco.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trovaparco.R
import com.trovaparco.data.model.Park

class ParkAdapter(
    private var parks: List<Park>,
    private val onParkClick: (Park) -> Unit
) : RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    inner class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvParkName: TextView = itemView.findViewById(R.id.tv_park_name)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onParkClick(parks[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val park = parks[position]
        holder.tvParkName.text = park.name
    }

    override fun getItemCount(): Int = parks.size

    fun updateParks(newParks: List<Park>) {
        parks = newParks
        notifyDataSetChanged()
    }
}
