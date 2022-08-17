package com.example.retrofitv1


import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.retrofitv1.database.*
import com.example.retrofitv1.pojo.ArticleResponse
import kotlinx.coroutines.launch

class ArticleViewModel(private val articleItemRepository: ArticleItemRepository) : ViewModel() {

    val allArticleItems : LiveData<List<ArticleResponse>> = articleItemRepository.alArticleItems as LiveData<List<ArticleResponse>>

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insert(articleItem: ArticleResponse) = viewModelScope.launch {
        articleItemRepository.insert(articleItem)
    }

    fun delete(articleItem: ArticleResponse) = viewModelScope.launch {
        articleItemRepository.delete(articleItem)
    }

    class ArticleViewModelFactory(private val articleItemRepository: ArticleItemRepository)
        :ViewModelProvider.Factory{
         override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ArticleViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return ArticleViewModel(articleItemRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}