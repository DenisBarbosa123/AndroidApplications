package com.example.androidproject04.productdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject04.persistence.Product
import com.example.androidproject04.persistence.ProductRepository

class ProductDetailViewModel(private val code: String?): ViewModel() {
    lateinit var product: MutableLiveData<Product>

    init {
        if(code != null){
            //getting the product using code
            getProduct(code)
        }
        else{
            //No code, it means that a new product might be created
            product = MutableLiveData<Product>()
            product.value = Product()
        }
    }

    private fun getProduct(code: String)
    {
        product = ProductRepository.getProductByCode(code)
    }

    fun deleteProduct() {
        if (product.value?.id != null) {
            ProductRepository.deleteProduct(product.value!!.id!!)
            product.value = null
        }
    }

    override fun onCleared() {
        if (product.value != null
            && product.value!!.code != null
            && product.value!!.code!!.isNotBlank()) {
            ProductRepository.saveProduct(product.value!!)
        }
        super.onCleared()
    }
}