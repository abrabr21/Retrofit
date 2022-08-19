package com.example.retrofitv1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.retrofitv1.Retrofit.RetrofitService
import com.example.retrofitv1.adapter.ArticleAdapter
import com.example.retrofitv1.common.Common
import com.example.retrofitv1.database.ArticleItemRoomDB
import com.example.retrofitv1.databinding.ActivityMainBinding
import com.example.retrofitv1.pojo.ArticleResponse
import com.example.retrofitv1.pojo.EntityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mService: RetrofitService by lazy {  Common.retrofitService }
    private val dataBase by lazy { Room
        .databaseBuilder(this, ArticleItemRoomDB::class.java, "datab")
        .allowMainThreadQueries()
        .build() }


    private val adapter by lazy { ArticleAdapter(arrayListOf())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       initUi()

        getAllArticleList()

    }

    private fun getAllArticleList() {

        mService.getArticlesList("us", "business").enqueue(object : Callback<EntityResponse> {
            override fun onFailure(call: Call<EntityResponse>, t: Throwable) {
                println("FAIL  " + t.message)
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<EntityResponse>,
                response: Response<EntityResponse>,
            ) {
                with(response.body() as EntityResponse) {
                    adapter.updateList(articleResponses)
                    dataBase.articleItemDao().insertAllArticles(articleResponses)

                 lifecycleScope.launch { Log.d("MainActivityLogs", "${dataBase.articleItemDao().getAll().first()}")}

                }
            }
        })

    }
    private  fun initUi(){
        with(binding.recyclerMovieList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

}