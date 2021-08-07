package com.example.imagesearch.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.imagesearch.BaseFragment
import com.example.imagesearch.R
import com.example.imagesearch.model.Image
import com.example.imagesearch.viewmodel.ImageSearchViewModel
import kotlinx.android.synthetic.main.fragment_image_search.*


class ImageSearchFragment : BaseFragment() {

    private val mTAG = ImageSearchAdapter::class.java.simpleName
    private lateinit var viewModel: ImageSearchViewModel
    private lateinit var imageSearchAdapter: ImageSearchAdapter
    private var imageList = ArrayList<Image>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_image_search, container, false)
        viewModel = ViewModelProvider(this).get(ImageSearchViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeToLiveDate()
    }

    // initialize recyclerview with adapter
    private fun initViews() {
        // set adapter value
        imageSearchAdapter = ImageSearchAdapter(imageList)
        rv_images.adapter = imageSearchAdapter

        btn_search.setOnClickListener {
            // get search hint
            var input = edt_image.text.toString()
            if(input.isEmpty()) input = BASE_INPUT

            viewModel.makeServiceCall(input)

            // hide progressbar and make API call
            updateProgressBar(View.VISIBLE)
        }
    }

    private fun subscribeToLiveDate() {
        viewModel.imageData.observe(viewLifecycleOwner, { list ->
            Log.d(mTAG, "Data received : $list")
            updateRecyclerView(list)
            updateProgressBar(View.INVISIBLE)
            hideKeyBoard()
        })
    }

    private fun updateRecyclerView(list: ArrayList<Image>) {
        imageList.clear()
        imageList.addAll(list)
        imageSearchAdapter.notifyDataSetChanged()
    }

    companion object {
        const val BASE_INPUT = "KEYBOARD"
    }

}