package com.meli.challengemeli.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.challengemeli.data.remote.SearchResultsDataSource
import com.meli.challengemeli.networking.RetrofitClient
import com.meli.challengemeli.repository.SearchRepositoryImpl
import com.meli.challengemeli.util.SearchStatus
import com.meli.challengemeli.util.Site
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel() : ViewModel() {

    private val searchRepository by lazy { SearchRepositoryImpl(SearchResultsDataSource(RetrofitClient.buildRetrofitClient())) }

    private val mutableSearchResults = MutableLiveData<SearchStatus>()
    val searchResults: LiveData<SearchStatus>
        get() = mutableSearchResults

    fun findResults(siteId: Site, searchText: String) {
        mutableSearchResults.value = SearchStatus.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                mutableSearchResults.postValue(SearchStatus.Success(searchRepository.getSearchResults(siteId, searchText)))
            } catch (e: Throwable) {
                mutableSearchResults.postValue(SearchStatus.Error(e))
            }
        }
    }

}