package com.meli.challengemeli.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meli.challengemeli.data.remote.SearchResultsDataSource
import com.meli.challengemeli.networking.RetrofitClient
import com.meli.challengemeli.repository.SearchRepositoryImpl
import com.meli.challengemeli.util.Status
import kotlinx.coroutines.Dispatchers

class SearchViewModel() : ViewModel() {

    private val searchRepository by lazy { SearchRepositoryImpl(SearchResultsDataSource(RetrofitClient.buildRetrofitClient())) }

    fun fetchSearchResults() = liveData(Dispatchers.IO) {
        emit(Status.Loading())
        try {
            emit(Status.Success(searchRepository))
        } catch (e: Throwable) {
            emit(Status.Error(e))
        }
    }

}