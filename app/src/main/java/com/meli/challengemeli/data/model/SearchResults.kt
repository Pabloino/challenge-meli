package com.meli.challengemeli.data.model

data class SearchResults(val results: List<Result>)

data class Result(val title: String, val price: Int, val thumbnail: String, val attributes: List<Attribute>)

data class Attribute(val name: String, val valueName: String)