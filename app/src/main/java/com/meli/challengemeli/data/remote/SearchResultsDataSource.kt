package com.meli.challengemeli.data.remote

import com.meli.challengemeli.data.model.SearchResults
import com.meli.challengemeli.networking.WebService
import com.meli.challengemeli.util.Site

class SearchResultsDataSource(private val webService: WebService) {

    suspend fun getSearchResults(siteId: Site, searchText: String): SearchResults = webService.getSearchResults(siteId, searchText)

}