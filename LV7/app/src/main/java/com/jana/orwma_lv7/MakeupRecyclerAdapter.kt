package com.jana.orwma_lv7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MakeupRecyclerAdapter(private val items:List<MakeupItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MakeupViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MakeupViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MakeupViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImage: ImageView = itemView.findViewById(R.id.imageView)
        private val  productName: TextView = itemView.findViewById(R.id.textView)
        private val productPrice:TextView = itemView.findViewById(R.id.textView2)
        private val productRating :TextView = itemView.findViewById(R.id.textView3)
        private val productDescription:TextView = itemView.findViewById(R.id.textView4)

        fun bind(makeup:MakeupItem){
            Glide
                .with(itemView.context)
                .load(makeup.image_link)
                .into(photoImage)
            productName.text=makeup.name
            productPrice.text=makeup.price
            productRating.text=makeup.rating.toString()
            productDescription.text=makeup.description
        }
    }
}