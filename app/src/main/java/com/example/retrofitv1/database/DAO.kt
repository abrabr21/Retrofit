package com.example.retrofitv1.database

import androidx.room.*
import com.example.retrofitv1.pojo.Article


@Dao
interface DAO {
    @get:Query("SELECT * FROM article")
    val all: List<Any?>?

    @Query("SELECT * FROM article WHERE author = :author")
    fun getById(id: Long): Article?

    @Insert
    fun insert(employee: Article?)

    @Update
    fun update(employee: Article?)

    @Delete
    fun delete(employee: Article?)
}