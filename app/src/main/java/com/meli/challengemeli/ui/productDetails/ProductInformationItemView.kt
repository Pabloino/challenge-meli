package com.meli.challengemeli.ui.productDetails

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.meli.challengemeli.R
import com.meli.challengemeli.data.model.Attribute
import com.meli.challengemeli.databinding.ProductInformationItemBinding

class ProductInformationItemView(context: Context, productAttribute: Attribute) : LinearLayout(context) {

    private var binding: ProductInformationItemBinding

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.product_information_item, this)
        binding = ProductInformationItemBinding.bind(view)
        binding.infoName.text = productAttribute.name
        binding.infoValue.text = productAttribute.valueName
    }

}