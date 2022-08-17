package com.example.retrofitv1

import android.app.Application
import com.example.retrofitv1.database.ArticleItemRepository
import com.example.retrofitv1.database.ArticleItemRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy{ ArticleItemRoomDB.getDatabase(this,applicationScope)}
    val repository by lazy {ArticleItemRepository(database.articleItemDao())}
}