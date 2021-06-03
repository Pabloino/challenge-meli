package com.meli.challengemeli.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class SearchResults(val results: List<Result>)

@Parcelize
data class Result(val title: String, val price: Double, val thumbnail: String, val attributes: List<Attribute>) : Parcelable

@Parcelize
data class Attribute(val name: String, val valueName: String) : Parcelable