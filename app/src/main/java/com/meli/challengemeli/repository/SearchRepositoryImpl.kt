package com.meli.challengemeli.repository

import com.meli.challengemeli.data.model.SearchResults
import com.meli.challengemeli.data.remote.SearchResultsDataSource
import com.meli.challengemeli.util.Site

class SearchRepositoryImpl(private val searchResultsDataSource: SearchResultsDataSource) : SearchRepository {

    override suspend fun getSearchResults(siteId: Site, query: String): SearchResults = searchResultsDataSource.getSearchResults(siteId, query)

}