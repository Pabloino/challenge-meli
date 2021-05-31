package com.meli.challengemeli.networking

import com.meli.challengemeli.data.model.SearchResults
import com.meli.challengemeli.util.Site
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("$SITES_URL_SEGMENT/$SITE_ID/$SEARCH_URL_SEGMENT")
    suspend fun getSearchResults(@Path(SITE_ID) siteId: Site, @Query(Q_PARAM) searchText: String): SearchResults

    companion object {
        private const val SITE_ID = "SITE_ID"
        private const val Q_PARAM = "q"
        private const val SITES_URL_SEGMENT = "sites"
        private const val SEARCH_URL_SEGMENT = "search"
    }
}