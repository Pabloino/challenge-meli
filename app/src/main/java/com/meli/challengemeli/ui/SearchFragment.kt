package com.meli.challengemeli.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meli.challengemeli.R
import com.meli.challengemeli.databinding.SearchFragmentBinding
import com.meli.challengemeli.util.Site
import com.meli.challengemeli.util.Status
import com.meli.challengemeli.viewModel.SearchViewModel

class SearchFragment : Fragment(R.layout.search_fragment) {

    private lateinit var binding: SearchFragmentBinding
    private val viewModel by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SearchFragmentBinding.bind(view)

        setUpSearchField()
        setUpResultsObserver()
    }

    private fun setUpSearchField() {
        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.findResults(Site.MLA, it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun setUpResultsObserver() {
        viewModel.searchResults.observe(viewLifecycleOwner, { status ->
            when(status) {
                is Status.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.resultsRecyclerView.visibility = View.GONE
                }
                is Status.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.resultsRecyclerView.visibility = View.VISIBLE
                }
                is Status.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${status.error}")
                }
            }
        })
    }
}