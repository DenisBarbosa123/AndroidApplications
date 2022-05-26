package com.example.androidproject02.productdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject02.databinding.FragmentProductDetailBinding
import com.example.androidproject02.databinding.FragmentProductsListBinding

private const val TAG = "ProductDetailFragment"
class ProductDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "Creating ProductDetailFragment")

        val binding = FragmentProductDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this

        //Fetch the product and create the ViewModel
        val productCode = ProductDetailFragmentArgs.fromBundle(requireArguments()).productCode
        val productDetailViewModelFactory = ProductDetailViewModelFactory(productCode)
        binding.productDetailViewModel = ViewModelProvider(this, productDetailViewModelFactory)
            .get(ProductDetailViewModel::class.java)

        return binding.root
    }
}