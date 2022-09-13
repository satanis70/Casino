package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.model.statsModel.StatsModelItem

class HolderStats(var listStats: ArrayList<StatsModelItem>)
    : RecyclerView.Adapter<HolderStats.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_stats_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(listStats[position].team,
            listStats[position].tournament,
            listStats[position].kicks,
            listStats[position].rating
        )
    }

    override fun getItemCount(): Int {
        return listStats.size
    }

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvNameTeam = itemView.findViewById<TextView>(R.id.text_view_team)
        private val tvTournament = itemView.findViewById<TextView>(R.id.text_view_tournament)
        private val tvKicks = itemView.findViewById<TextView>(R.id.text_view_kicks)
        private val tvRate = itemView.findViewById<TextView>(R.id.text_view_rate)

        fun bind(nameTeam: String, tournament: String, kicks: Double, rate: Double){
            tvNameTeam.text = nameTeam
            tvTournament.text = tournament
            tvKicks.text = kicks.toString()
            tvRate.text = rate.toString()
        }
    }


}