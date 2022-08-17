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

    companion object {

        @Volatile
        private var INSTANCE: ArticleItemRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ArticleItemRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleItemRoomDB::class.java,
                    "article_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
    private class ArticleItemCallback(val scope :CoroutineScope):RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let{articalItemRoomDB->
                scope.launch {
                    var mService = Common.retrofitService
                    println(mService.getArticlesList("us", "business").awaitResponse())


                }
                scope.launch {

                }

            }
        }
    }
}