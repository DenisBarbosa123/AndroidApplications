package com.example.androidproject02.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject02.databinding.FragmentProductsListBinding

private const val TAG = "ProductsListFragment"
class ProductsListFragment: Fragment() {
    private val productListViewModel : ProductListViewModel by lazy {
        ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductsListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.productListViewModel = productListViewModel

        val itemDecor = DividerItemDecoration(context, RecyclerView.VERTICAL)
        binding.rcvProducts.addItemDecoration(itemDecor)

        binding.rcvProducts.adapter = ProductAdapter(ProductAdapter.ProductClickListener{ product->
            Log.i(TAG, "Product selected ${product.name}")
            this.findNavController()
                .navigate(ProductsListFragmentDirections.actionShowProductDetail(product.code))
        })

        binding.productsRefresh.setOnRefreshListener {
            Log.i(TAG, "Refreshing products list")
            productListViewModel.refreshProducts()
            binding.productsRefresh.isRefreshing = false
        }

        return binding.root
    }
}