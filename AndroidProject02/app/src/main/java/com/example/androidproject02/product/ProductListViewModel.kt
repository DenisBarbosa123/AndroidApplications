package com.example.androidproject02.product

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidproject02.network.SalesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "ProductListViewModel"
class ProductListViewModel: ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getProducts()
    }

    private fun getProducts(){
        Log.i(TAG, "Preparing to request product list")
        coroutineScope.launch {
            val getProductDeferred = SalesApi.retrofitService.getProducts()
            Log.i(TAG, "Fetching products")
            val productList = getProductDeferred.await()
            Log.i(TAG, "Products obtained with size ${productList.size}")
        }
        Log.i(TAG, "Product list has been already requested")
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}