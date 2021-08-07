package com.example.imagesearch

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_image_search.*

abstract class BaseFragment : Fragment() {

    protected fun updateProgressBar(state: Int) {
        pb_loading.visibility = state
    }

    protected fun hideKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }
}