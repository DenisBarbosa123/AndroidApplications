package com.example.androidproject02.product

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject02.network.Product

@BindingAdapter("productsList")
fun bindProductsList(recyclerView: RecyclerView, products: List<Product>?) {
    val adapter = recyclerView.adapter as ProductAdapter
    adapter.submitList(products)
}

@BindingAdapter("productPrice")
fun bindProductsList(txtProductPrice: TextView, productPrice: Double?) {
    txtProductPrice.text = productPrice?.let { price -> "$ " + "%.2f".format(price) }
}
