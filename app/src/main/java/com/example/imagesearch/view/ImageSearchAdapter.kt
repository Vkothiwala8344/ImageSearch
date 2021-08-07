package com.example.imagesearch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearch.R
import com.example.imagesearch.model.Image

class ImageSearchAdapter(private val imageList: ArrayList<Image>) :
    RecyclerView.Adapter<ImageSearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = imageList[position]
        holder.bind(holder, image)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val colorImage: ImageView = itemView.findViewById(R.id.iv_image)
        private val colorTitle: TextView = itemView.findViewById(R.id.tv_image_title)
        private val colorHex: TextView = itemView.findViewById(R.id.tv_image_hex)

        fun bind(holder: ViewHolder, image: Image) {
            // set image name and hex
            holder.colorTitle.text =
                holder.colorTitle.context.getString(R.string.image_list_item_title, image.title)
            holder.colorHex.text =
                holder.colorHex.context.getString(R.string.image_list_item_hex, image.hex)

            // download and set image to circular imageview
            Glide.with(holder.colorImage.context)
                .load(image.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.colorImage)
        }
    }
}