package com.example.retrofitv1.database

import androidx.room.*
import com.example.retrofitv1.pojo.ArticleResponse


@Dao
interface DAO {
    @get:Query("SELECT * FROM article")
    val all: List<Any?>?

    @Query("SELECT * FROM article WHERE author = :author")
    fun getById(id: Long): ArticleResponse?

    @Insert
    fun insert(employee: ArticleResponse?)

    @Update
    fun update(employee: ArticleResponse?)

    @Delete
    fun delete(employee: ArticleResponse?)
}