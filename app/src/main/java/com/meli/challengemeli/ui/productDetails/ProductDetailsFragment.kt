package com.meli.challengemeli.ui.productDetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.meli.challengemeli.R
import com.meli.challengemeli.databinding.ProductDetailsFragmentBinding
import com.meli.challengemeli.ui.BaseFragment
import com.meli.challengemeli.viewModel.ActionBarStatus
import com.squareup.picasso.Picasso

class ProductDetailsFragment : BaseFragment(R.layout.product_details_fragment) {

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

            attributes.forEach {
                binding.productInformationContent.addView(ProductInformationItemView(requireContext(), it))
            }
        }
    }

    override fun getActionBarStatus(): ActionBarStatus = ActionBarStatus(requireContext().resources.getString(R.string.product_title), true)
}