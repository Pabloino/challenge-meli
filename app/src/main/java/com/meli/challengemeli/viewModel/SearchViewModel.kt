package com.meli.challengemeli.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.challengemeli.data.model.SearchResults
import com.meli.challengemeli.data.remote.SearchResultsDataSource
import com.meli.challengemeli.networking.RetrofitClient
import com.meli.challengemeli.repository.SearchRepositoryImpl
import com.meli.challengemeli.util.Status
import com.meli.challengemeli.util.Site
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val searchRepository by lazy { SearchRepositoryImpl(SearchResultsDataSource(RetrofitClient.buildRetrofitClient())) }

    private val mutableSearchResults = MutableLiveData<Status<SearchResults>>()
    val searchResults: LiveData<Status<SearchResults>>
        get() = mutableSearchResults

    fun findResults(siteId: Site, query: String) {
        mutableSearchResults.value = Status.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                mutableSearchResults.postValue(Status.Success(searchRepository.getSearchResults(siteId, query)))
            } catch (e: Throwable) {
                mutableSearchResults.postValue(Status.Error(e))
            }
        }
    }

}