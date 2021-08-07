package com.example.imagesearch.repository.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imagesearch.model.Image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepository {

    private val mTAG = ImageRepository::class.java.simpleName

    private val apiClient = ApiClient.getInstance()
    var images = MutableLiveData<ArrayList<Image>>()

    internal fun makeServiceCall(input: String) {

        val service = apiClient.getImages(input, FORMAT, IMAGE_COUNT)

        service.enqueue(object : Callback<ArrayList<Image>> {
            override fun onResponse(
                call: Call<ArrayList<Image>>,
                response: Response<ArrayList<Image>>
            ) {
                Log.d(mTAG, "Response success : ${response.code()} , ${response.body()}")
                images.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Image>>, t: Throwable) {
                Log.d(mTAG, "Response failure : $t")
            }
        })
    }

    companion object {
        const val FORMAT = "json"
        const val IMAGE_COUNT = 20
    }

}