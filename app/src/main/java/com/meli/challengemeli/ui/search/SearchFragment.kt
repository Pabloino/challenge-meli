package com.meli.challengemeli.ui.search

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.meli.challengemeli.R
import com.meli.challengemeli.data.model.Result
import com.meli.challengemeli.databinding.SearchFragmentBinding
import com.meli.challengemeli.ui.adapters.SearchResultsAdapter
import com.meli.challengemeli.util.Site
import com.meli.challengemeli.util.Status
import com.meli.challengemeli.viewModel.SearchViewModel

class SearchFragment : Fragment(R.layout.search_fragment), SearchResultsAdapter.OnResultClickListener {

    private lateinit var binding: SearchFragmentBinding
    private val viewModel by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SearchFragmentBinding.bind(view)
        binding.resultsRecyclerView.addItemDecoration(DividerItemDecoration(binding.resultsRecyclerView.context, DividerItemDecoration.VERTICAL))
        setUpSearchField()
        setUpResultsObserver()
    }

    private fun setUpSearchField() {
        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchField.clearFocus()
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
                    binding.resultsRecyclerView.adapter = SearchResultsAdapter(status.data.results, this)
                }
                is Status.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "Se produjo un error: ${status.error}", Toast.LENGTH_LONG).show()
                    Log.d("Error", "${status.error}")
                }
            }
        })
    }

    override fun onResultClick(result: Result) {
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToProductDetailsFragment(result))
    }
}