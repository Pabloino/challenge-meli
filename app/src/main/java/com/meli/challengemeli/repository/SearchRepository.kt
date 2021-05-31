package com.meli.challengemeli.repository

import com.meli.challengemeli.data.model.searchItems.SearchResults
import com.meli.challengemeli.util.Site

interface SearchRepository {

    suspend fun getSearchResults(siteId: Site, searchText: String): SearchResults

}