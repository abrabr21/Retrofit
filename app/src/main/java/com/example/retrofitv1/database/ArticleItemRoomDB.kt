package com.example.retrofitv1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.retrofitv1.adapter.ArticleAdapter
import com.example.retrofitv1.common.Common
import com.example.retrofitv1.pojo.ArticleResponse
import com.example.retrofitv1.pojo.EntityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.*

@Database(entities = [ArticleResponse::class], version = 1, exportSchema = false)
public abstract class ArticleItemRoomDB : RoomDatabase() {

    abstract fun articleItemDao(): ArticleItemDao

}