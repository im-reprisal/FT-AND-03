package com.masai.sprint_2.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PeopleRepo {
    fun getPagesList() = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = {PeoplePagingSource()}
    ).liveData
}