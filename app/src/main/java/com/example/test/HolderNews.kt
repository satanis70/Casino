package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.model.newsModel.NewsModelItem

class HolderNews(var listNews: ArrayList<NewsModelItem>)
    : RecyclerView.Adapter<HolderNews.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderNews.MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_news_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: HolderNews.MainHolder, position: Int) {
        holder.bind(listNews[position].img,
        listNews[position].tittle,
        listNews[position].text,
        listNews[position].date)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    inner class MainHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val imageView = itemView.findViewById<ImageView>(R.id.image_view_news)
        private val tvTitle = itemView.findViewById<TextView>(R.id.text_view_title_news)
        private val tvText = itemView.findViewById<TextView>(R.id.text_view_text_news)
        private val tvDate = itemView.findViewById<TextView>(R.id.text_view_date_news)

        fun bind(image: String, title: String, text: String, date: String){
            Glide.with(itemView.context)
                .load(image)
                .centerCrop()
                .into(imageView)
            tvTitle.text = title
            tvText.text = text
            tvDate.text = date

        }
    }
}