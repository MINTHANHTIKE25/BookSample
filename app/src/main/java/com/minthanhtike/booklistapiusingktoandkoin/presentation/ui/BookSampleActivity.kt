package com.minthanhtike.booklistapiusingktoandkoin.presentation.ui

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.minthanhtike.booklistapiusingktoandkoin.R
import com.minthanhtike.booklistapiusingktoandkoin.data.repository.BookSampleRepo
import com.minthanhtike.booklistapiusingktoandkoin.presentation.viewmodel.BookSampleViewModel
import com.minthanhtike.booklistapiusingktoandkoin.presentation.viewmodel.ScreenState
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookSampleActivity : AppCompatActivity() {
    private val bookSampleViewModel: BookSampleViewModel by viewModel()
    private lateinit var progressBar: ProgressBar
    private lateinit var bookRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_sample_activity)

        progressBar = findViewById(R.id.circular_indicator)
        bookRecyclerView = findViewById(R.id.book_list_rv)

        progressBar.visibility = View.GONE
        val adapter = BookAdapter()
        bookRecyclerView.adapter = adapter
        bookRecyclerView.layoutManager = GridLayoutManager(
            this, 2, GridLayoutManager.VERTICAL, false
        )

        bookSampleViewModel.bookSampleList.observeForever {
            when (it) {
                is ScreenState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is ScreenState.Success -> {
                    progressBar.visibility = View.GONE
                    adapter.updateBookList(it.data)
                }

                is ScreenState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this,it.error,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}