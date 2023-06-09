package com.example.mymaps

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymaps.models.UserMap

private const val TAG = "MapsAdapter"
class MapsAdapter(val context: MainActivity, val userMaps: List<UserMap>, val onCLickListener: OnClicklistener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface OnClicklistener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            Log.i(TAG, "Tapped on position $position")
            onCLickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTitle)
        val textViewMarker = holder.itemView.findViewById<TextView>(R.id.tvMarkers)
        textViewTitle.text = userMap.title
        val numOfMarkers = userMap.places.size.toString()
        textViewMarker.text = "Markers : $numOfMarkers"
    }

    override fun getItemCount() = userMaps.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
