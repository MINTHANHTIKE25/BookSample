package com.minthanhtike.booklistapiusingktoandkoin.presentation.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minthanhtike.booklistapiusingktoandkoin.R
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.BookSample
import org.w3c.dom.Text

class BookSampleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var bookIv: ImageView = itemView.findViewById(R.id.book_img)
    private var authorTv: TextView = itemView.findViewById(R.id.author_txt)
    private var bookNameTv: TextView = itemView.findViewById(R.id.book_title_txt)

    fun onBind(bookSample: BookSample) {
        Glide.with(itemView.context)
            .load(bookSample.bookCover)
            .into(bookIv)
        authorTv.text = bookSample.author.name
        bookNameTv.text = bookSample.name
    }
}