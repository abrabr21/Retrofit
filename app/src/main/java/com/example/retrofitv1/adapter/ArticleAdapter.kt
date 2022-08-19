package com.example.retrofitv1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitv1.R
import com.example.retrofitv1.pojo.ArticleResponse
import com.example.retrofitv1.pojo.EntityResponse
import com.squareup.picasso.Picasso

class ArticleAdapter(private var articleList: List<ArticleResponse>):
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
        val txt_team: TextView = itemView.findViewById(R.id.txt_team)
        val content: TextView = itemView.findViewById(R.id.txt_createdby)

        fun bind(listItem: ArticleResponse) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${image}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${txt_name.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() =  articleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = articleList [position]
        holder.bind(listItem)

        Picasso.get().load(listItem.urlToImage).into(holder.image)
        holder.txt_name.text = listItem.title
        holder.txt_team.text = listItem.author
        holder.content.text = listItem.content
    }

    fun updateList(newArticleList : List<ArticleResponse>){
        articleList = newArticleList
        notifyDataSetChanged()
    }

}
