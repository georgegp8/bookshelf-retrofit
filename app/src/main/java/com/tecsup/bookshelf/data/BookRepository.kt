package com.tecsup.bookshelf.data

import com.tecsup.bookshelf.model.BookItem

class BookRepository(private val api: BookApiService) {

    suspend fun getBooks(query: String): List<BookItem> {
        return api.searchBooks(query).items ?: emptyList()
    }

    suspend fun getBookById(bookId: String): BookItem {
        val response = api.getBookById(bookId)
        return BookItem(
            id = response.id,
            volumeInfo = response.volumeInfo
        )
    }
}