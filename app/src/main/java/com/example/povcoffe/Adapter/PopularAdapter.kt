package com.example.povcoffe.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.povcoffe.Activity.DetailActivity
import com.example.povcoffe.Model.ItemsModel
import com.example.povcoffe.databinding.ViewholderPopularBinding

class PopularAdapter(val items:MutableList<ItemsModel>):
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {

        private var context:Context? = null
    class Viewholder(val binding: ViewholderPopularBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.Viewholder {
        context=parent.context
        val binding=ViewholderPopularBinding.inflate(LayoutInflater.from(context),parent,false)
    return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text=items[position].title
        holder.binding.princeTxt.text="$"+ items[position].price.toString()
        holder.binding.ratingBar.rating = items[position].rating.toFloat()
        holder.binding.extraTxt.text = items[position].extra

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int=items.size
}