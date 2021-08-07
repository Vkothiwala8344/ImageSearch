package com.example.imagesearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imagesearch.model.Image
import com.example.imagesearch.repository.service.ImageRepository

class ImageSearchViewModel : ViewModel() {

    private val repository = ImageRepository()
    val imageData: LiveData<ArrayList<Image>> = repository.images

    internal fun makeServiceCall(input: String) {
        repository.makeServiceCall(input)
    }

}