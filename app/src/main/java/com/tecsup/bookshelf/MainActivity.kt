package com.tecsup.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tecsup.bookshelf.data.BookApiService
import com.tecsup.bookshelf.ui.screen.BookGridScreen
import com.tecsup.bookshelf.viewmodel.BookViewModel
import com.tecsup.bookshelf.data.BookRepository
import com.tecsup.bookshelf.ui.screen.BookDetailScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookApiService::class.java)

        val repository = BookRepository(api)
        val viewModel = BookViewModel(repository)

        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "grid") {
                composable("grid") {
                    BookGridScreen(viewModel) { bookId ->
                        navController.navigate("detail/$bookId")
                    }
                }
                composable("detail/{bookId}") { backStackEntry ->
                    val bookId = backStackEntry.arguments?.getString("bookId") ?: return@composable
                    BookDetailScreen(
                        bookId = bookId,
                        viewModel = viewModel,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}