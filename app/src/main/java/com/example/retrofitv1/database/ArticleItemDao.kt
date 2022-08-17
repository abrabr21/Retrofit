package com.example.retrofitv1.database

import androidx.room.*
import com.example.retrofitv1.pojo.ArticleResponse
import kotlinx.coroutines.flow.Flow
@Dao
interface ArticleItemDao {
    @Query("SELECT * FROM Articles ORDER BY title")
    fun getArticleItems(): Flow<List<ArticleResponse>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(articleItem: ArticleResponse)

    @Delete
    suspend fun delete(articleItem: ArticleResponse)
}