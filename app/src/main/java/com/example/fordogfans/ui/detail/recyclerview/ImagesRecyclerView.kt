package com.example.fordogfans.ui.detail.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.fordogfans.databinding.DogImageListItemBinding

class ImagesViewHolder(val viewBinding: DogImageListItemBinding) : ViewHolder(viewBinding.root) {
     var width: Int = 0
     var height: Int = 0
    fun bind(item: String) {
        Glide.with(viewBinding.root).load(item).centerCrop()
//            .addListener(object : RequestListener<Drawable> {
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ) =
//                    false
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    resource?.let {
//                        width = resource.intrinsicWidth
//                        height = resource.intrinsicHeight
//                        //use these sizes whatever needed for
//                        viewBinding.dogImage.setImageDrawable(resource)
//                    }
//                    return false
//                }
//            }
//            ).preload(width,height)
            .into(viewBinding.dogImage)
    }
}

class ImagesDataAdapter(var data: List<String>) : RecyclerView.Adapter<ImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val viewBinding =
            DogImageListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun updateData(newData: List<String>) {
        data = newData
        notifyDataSetChanged()
    }

}