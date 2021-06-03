package com.meli.challengemeli.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.meli.challengemeli.R
import com.meli.challengemeli.databinding.ProductDetailsFragmentBinding
import com.squareup.picasso.Picasso

class ProductDetailsFragment : Fragment(R.layout.product_details_fragment) {

    private lateinit var binding: ProductDetailsFragmentBinding
    private val args by navArgs<ProductDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ProductDetailsFragmentBinding.bind(view)

        with(args.product) {
            binding.title.text = title
            binding.price.text = "$${if ((price % 1) == 0.0) price.toInt() else price}"

            Picasso.get()
                .load(thumbnail)
                .into(binding.imageProduct)
        }
    }
}