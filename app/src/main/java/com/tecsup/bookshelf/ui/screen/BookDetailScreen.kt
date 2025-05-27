package com.tecsup.bookshelf.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tecsup.bookshelf.model.BookItem
import com.tecsup.bookshelf.viewmodel.BookViewModel

@Composable
fun BookDetailScreen(bookId: String, viewModel: BookViewModel, onBack: () -> Unit) {
    val book = remember { mutableStateOf<BookItem?>(null) }

    LaunchedEffect(bookId) {
        book.value = viewModel.getBookById(bookId)
    }

    book.value?.let { b ->
        val info = b.volumeInfo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = info.imageLinks?.thumbnail?.replace("http", "https"),
                contentDescription = info.title.orEmpty(),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .aspectRatio(3f / 4f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(info.title.orEmpty(), style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            Text("Autor(es): ${info.authors?.joinToString().orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Editorial: ${info.publisher.orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Fecha de publicación: ${info.publishedDate.orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Páginas: ${info.pageCount?.toString().orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Text("Descripción:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(info.description.orEmpty(), style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}