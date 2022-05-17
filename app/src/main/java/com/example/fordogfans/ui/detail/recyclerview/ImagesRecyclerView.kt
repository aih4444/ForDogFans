package com.example.fordogfans.ui.detail.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.example.fordogfans.databinding.DogImageListItemBinding

class ImagesViewHolder(val viewBinding: DogImageListItemBinding) : ViewHolder(viewBinding.root) {
}

class ImagesDataAdapter(var data: List<String>) : RecyclerView.Adapter<ImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val viewBinding = DogImageListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ImagesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.viewBinding.dogImage.load(data[position]){
            scale(Scale.FIT)
            transformations(RoundedCornersTransformation(20f))
        }
    }

    override fun getItemCount(): Int = data.size

    fun updateData(newData: List<String>) {
        data = newData
        notifyDataSetChanged()
    }

}