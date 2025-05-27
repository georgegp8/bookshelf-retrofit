package com.tecsup.bookshelf.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.bookshelf.data.BookRepository
import com.tecsup.bookshelf.model.BookItem
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    private val _books = mutableStateOf<List<BookItem>>(emptyList())
    val books: State<List<BookItem>> = _books

    suspend fun getBookById(bookId: String): BookItem? {
        return repository.getBookById(bookId)
    }

    fun searchBooks(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) return@launch //Evita llamada vacía
            val result = repository.getBooks(query)
            _books.value = result
        }
    }
    init {
        viewModelScope.launch {
            val result = repository.getBooks("jazz history")
            _books.value = result
        }
    }

}
