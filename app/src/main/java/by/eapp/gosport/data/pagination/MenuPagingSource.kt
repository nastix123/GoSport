package by.eapp.gosport.data.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import by.eapp.gosport.data.mappers.toMenuItem
import by.eapp.gosport.data.remote.ApiService
import by.eapp.gosport.domain.model.MenuItem
import retrofit2.HttpException
import java.io.IOException

class MenuPagingSource(
    private val apiService: ApiService
): PagingSource<Int, MenuItem>() {
    override fun getRefreshKey(state: PagingState<Int, MenuItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MenuItem> {
        return try {
            val currentPage = params.key?:1
            val meals = apiService.getMenu().body()
            val nextKey = if (meals!!.isEmpty()) null else currentPage + 1
            LoadResult.Page(
                data = meals.map {
                    it.toMenuItem()
                },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextKey
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}