package com.minthanhtike.booklistapiusingktoandkoin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.minthanhtike.booklistapiusingktoandkoin.data.repository.BookSampleRepo
import com.minthanhtike.booklistapiusingktoandkoin.domain.Resources
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.BookSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookSampleViewModel(
    private val bookSampleRepo: BookSampleRepo
) : ViewModel() {
    private val _bookSampleList = MutableLiveData<ScreenState>()
    val bookSampleList:LiveData<ScreenState> = _bookSampleList

    init {
        getBookSample()
    }

    private fun getBookSample() {
        viewModelScope.launch() {
            _bookSampleList.value = ScreenState.Loading
            when (val result = bookSampleRepo.getBookSample()) {
                is Resources.Success -> {
                    _bookSampleList.value = ScreenState.Success(result.success)
                }

                is Resources.Error -> {
                    _bookSampleList.value = ScreenState.Error(result.error)
                }
            }
        }
    }
}

sealed class ScreenState {
    data object Loading : ScreenState()
    data class Success(val data: List<BookSample>) : ScreenState()
    data class Error(val error: String) : ScreenState()
}