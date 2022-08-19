package com.example.retrofitv1.database

import androidx.room.*
import com.example.retrofitv1.pojo.ArticleResponse
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleItemDao {
    @Query("SELECT * FROM articles")
     fun getAll(): Flow<List<ArticleResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArticles(articleResponse: List<ArticleResponse>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(articleItem: ArticleResponse)

    @Delete
     fun delete(articleItem: ArticleResponse)
}