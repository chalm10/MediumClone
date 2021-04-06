package com.example.mediumclone.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api.models.entities.Article
import com.example.mediumclone.R
import kotlinx.android.synthetic.main.item_list_feed.view.*

//try to implement listadapter

class FeedAdapter(val list: List<Article>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(article: Article) {
            with(itemView){
                authorTextView.text = article.author.username
                titleTextView.text = article.title
                bodySnippetTextView.text = article.description
                Glide.with(this)
                    .load(article.author.image)
                    .placeholder(R.drawable.default_avatar)
                    .into(avatarImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_feed,parent,false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


}