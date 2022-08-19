package com.example.retrofitv1.database

import android.support.annotation.WorkerThread
import com.example.retrofitv1.Retrofit.RetrofitService
import com.example.retrofitv1.pojo.ArticleResponse
import kotlinx.coroutines.flow.Flow

class ArticleItemRepository(private val articleItemDao: ArticleItemDao) {

    val alArticleItems: Flow<List<ArticleResponse>> = articleItemDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(articleItem: ArticleResponse){
        articleItemDao.insert(articleItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(articleItem: ArticleResponse){
        articleItemDao.delete(articleItem)
    }

}