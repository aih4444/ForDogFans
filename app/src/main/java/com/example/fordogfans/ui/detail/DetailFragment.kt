package com.example.fordogfans.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fordogfans.databinding.FragmentDetailBinding
import com.example.fordogfans.ui.detail.recyclerview.ImagesDataAdapter
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment(), DetailView {

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val presenter: DetailPresenter by inject()
    private val imagesDataAdapter = ImagesDataAdapter(emptyList())

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)

        binding.imagesRecyclerview.apply {
            adapter = imagesDataAdapter
            layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        }

        val args: DetailFragmentArgs by navArgs()
        presenter.getRandomImagesOfBreed(args.dogBreed)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRetrievedDogImageUrls(imagesUrls: List<String>) {
        Log.d("TAG", "onRetrievedDogImageUrls: ${imagesUrls[0]}")
        imagesDataAdapter.updateData(imagesUrls)
    }
}