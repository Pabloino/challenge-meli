package com.meli.challengemeli.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.challengemeli.data.model.Result
import com.meli.challengemeli.databinding.SearchResultItemBinding
import com.squareup.picasso.Picasso

class SearchResultsAdapter(private val results: List<Result>) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    inner class ItemViewHolder(private val binding: SearchResultItemBinding) : BaseViewHolder<Result>(binding.root) {
        override fun bind(item: Result) {
            binding.title.text = item.title
            val price = if ((item.price % 1) == 0.0) item.price.toInt() else item.price
            binding.price.text = "$${price}"
            Picasso.get()
                .load(item.thumbnail)
                .into(binding.imageProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = SearchResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is ItemViewHolder -> holder.bind(results[position])
        }
    }

    override fun getItemCount(): Int = results.size
}