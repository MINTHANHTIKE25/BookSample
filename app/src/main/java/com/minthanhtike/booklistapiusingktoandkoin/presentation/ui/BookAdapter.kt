package com.minthanhtike.booklistapiusingktoandkoin.presentation.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.booklistapiusingktoandkoin.R
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.BookSample
import com.minthanhtike.booklistapiusingktoandkoin.presentation.viewHolder.BookSampleVH

class BookAdapter : RecyclerView.Adapter<BookSampleVH>() {
    private var bookSampleList = emptyList<BookSample>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSampleVH {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.book_sample_viewholder, parent, false)
            .apply {
                return BookSampleVH(
                    itemView = this
                )
            }
    }

    override fun getItemCount(): Int {
        return bookSampleList.size
    }

    override fun onBindViewHolder(holder: BookSampleVH, position: Int) {
        holder.onBind(bookSampleList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateBookList(bookList: List<BookSample>) {
        bookSampleList=bookList
        notifyDataSetChanged()
    }
}