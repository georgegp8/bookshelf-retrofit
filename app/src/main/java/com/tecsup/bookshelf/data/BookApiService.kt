package com.tecsup.bookshelf.data

import com.tecsup.bookshelf.model.BookResponse
import com.tecsup.bookshelf.model.VolumeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String
    ): BookResponse

    @GET("volumes/{id}")
    suspend fun getBookById(@Path("id") id: String): VolumeResponse

}