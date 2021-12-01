package com.example.search.data

data class Data(
    val addressList: List<Address>,
    val autoCompleteRequestString: String,
    val focusWord: String,
    val totalFindByRSUHits: Int,
    val totalNoRSUReturned: Int
)