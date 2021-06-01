package com.meli.challengemeli.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.meli.challengemeli.R
import com.meli.challengemeli.databinding.SearchFragmentBinding

class SearchFragment : Fragment(R.layout.search_fragment) {

    private lateinit var binding: SearchFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SearchFragmentBinding.bind(view)

        setUpSearchField()
    }

    private fun setUpSearchField() {
        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { Log.d("CLICK", query) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }
}