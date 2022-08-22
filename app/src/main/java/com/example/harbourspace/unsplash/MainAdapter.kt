package com.example.harbourspace.unsplash


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.harbourspace.R
import com.example.harbourspace.unsplash.model.UnsplashItem
import kotlinx.android.synthetic.main.item_main.view.iv_preview
import kotlinx.android.synthetic.main.item_main.view.tv_author
import kotlinx.android.synthetic.main.item_main.view.tv_name

class MainAdapter(private var images: List<UnsplashItem>, val onClick: (Int) -> Unit):
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.iv_preview as ImageView
        val name = itemView.tv_name as TextView
        val author = itemView.tv_author as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder(inflater.inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val image = images[position]
        holder.image.setOnClickListener {
            onClick(position)
        }
        holder.name.text = image.description
        holder.author.text = image.user.name
    }

    fun submitList(newImages: List<UnsplashItem>) {
        images = newImages
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return images.size
    }
}