package com.example.test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.model.tableModel.Datum

class HolderTable(var listTable:ArrayList<Datum>) :  RecyclerView.Adapter<HolderTable.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_table_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(position+1,
            listTable[position].team,
            listTable[position].games,
            listTable[position].v,
            listTable[position].n,
            listTable[position].p,
            listTable[position].balls,
            listTable[position].points)
    }

    override fun getItemCount(): Int {
        return listTable.size
    }

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvNumberTeam = itemView.findViewById<TextView>(R.id.textView_number_team)
        private val tvNameTeam = itemView.findViewById<TextView>(R.id.textView_name_team)
        private val tvI = itemView.findViewById<TextView>(R.id.textViewI)
        private val tvV = itemView.findViewById<TextView>(R.id.textViewV)
        private val tvN = itemView.findViewById<TextView>(R.id.textViewN)
        private val tvP = itemView.findViewById<TextView>(R.id.textViewP)
        private val tvBalls = itemView.findViewById<TextView>(R.id.textView_balls)
        private val tvO = itemView.findViewById<TextView>(R.id.textViewO)

        fun bind(numberTeam: Int, nameTeam: String, i: Long, v: Long, n: Long, p: Long, balls: String, o: Long){
            tvNumberTeam.text = numberTeam.toString()
            tvNameTeam.text = nameTeam
            tvI.text = i.toString()
            tvV.text = v.toString()
            tvN.text = n.toString()
            tvP.text = p.toString()
            tvBalls.text = balls
            tvO.text = o.toString()
        }
    }
}