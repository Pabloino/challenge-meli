package com.meli.challengemeli.data.model

import com.meli.challengemeli.data.model.Attribute

data class Result(val title: String, val price: Int, val thumbnail: String, val attributes: List<Attribute>)
