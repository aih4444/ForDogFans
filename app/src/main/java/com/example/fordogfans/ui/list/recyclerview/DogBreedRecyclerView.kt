package com.example.fordogfans.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fordogfans.R
import com.example.fordogfans.databinding.DogBreedListItemBinding
import com.example.fordogfans.model.DogBreedList
import com.example.fordogfans.ui.list.ListFragmentDirections

class DogBreedViewHolder(val viewBinding: DogBreedListItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    private val supportFragmentManager: FragmentManager by lazy {
        (viewBinding.root.context as AppCompatActivity).supportFragmentManager
    }
    private val navController: NavController by lazy {
        (viewBinding.root.context as AppCompatActivity).findNavController(R.id.nav_host_fragment_content_main)
    }

    init {
        viewBinding.root.setOnClickListener {
            Toast.makeText(
                viewBinding.root.context,
                viewBinding.dogBreedNameItem.text,
                Toast.LENGTH_LONG
            ).show()
//            val fragment = DetailFragment()
//            fragment.arguments =
//                Bundle().apply { putString("ImageUrl", viewBinding.dogBreedNameItem.text.toString()) }
//            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment,"tag").commit()
            val action = ListFragmentDirections.actionFirstFragmentToSecondFragment(viewBinding.dogBreedNameItem.text.toString())
            navController.navigate(action)
        }


    }

}

class DogBreedAdapter(private var data: DogBreedList) : RecyclerView.Adapter<DogBreedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedViewHolder {
        val viewBinding = DogBreedListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DogBreedViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DogBreedViewHolder, position: Int) {
        holder.viewBinding.dogBreedNameItem.text = data.breeds[position].name
    }

    override fun getItemCount(): Int =
        data.breeds.size

    fun updateData(newData: DogBreedList) {
        data = newData
        notifyDataSetChanged()
    }
}