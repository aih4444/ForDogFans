package com.example.fordogfans.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fordogfans.databinding.FragmentListBinding
import com.example.fordogfans.model.DogBreedList
import com.example.fordogfans.ui.list.recyclerview.DogBreedAdapter
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment(), ListView {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val presenter: ListPresenter by inject()

    private val dogBreedsAdapter = DogBreedAdapter(DogBreedList())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setupView(this)
        binding.dogBreedRecyclerview.apply {
            adapter = dogBreedsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        presenter.getDogBreeds()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRetrievedDogBreeds(dogBreeds: DogBreedList) {
        dogBreedsAdapter.updateData(dogBreeds)
    }
}