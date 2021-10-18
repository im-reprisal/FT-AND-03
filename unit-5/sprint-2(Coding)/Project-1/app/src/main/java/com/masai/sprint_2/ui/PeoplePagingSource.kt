package com.masai.sprint_2.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.sprint_2.data.models.PeopleResponse
import com.masai.sprint_2.data.models.PeopleResponseItem
import com.masai.sprint_2.network.ServiceGenerator

class PeoplePagingSource:PagingSource<Int,PeopleResponseItem>() {
    private val apiClient = ServiceGenerator.getApiService()


    override fun getRefreshKey(state: PagingState<Int, PeopleResponseItem>): Int? {
      return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PeopleResponseItem> {
        val pageNumber = params.key ?: 1;

        val peopleResponse: PeopleResponse = apiClient.getApiResponse(pageNumber)
        val tvPeopleResponseItem: ArrayList<PeopleResponseItem> = peopleResponse
        return try {
            LoadResult.Page(data = tvPeopleResponseItem,prevKey = null,nextKey = if (
                tvPeopleResponseItem.isEmpty()) null else pageNumber + 1
                    )
        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
}