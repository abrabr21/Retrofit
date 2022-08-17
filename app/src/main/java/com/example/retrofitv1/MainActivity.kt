package com.example.retrofitv1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.retrofitv1.Retrofit.RetrofitService
import com.example.retrofitv1.adapter.ArticleAdapter
import com.example.retrofitv1.common.Common
import com.example.retrofitv1.databinding.ActivityMainBinding
import com.example.retrofitv1.pojo.EntityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mService: RetrofitService
    private lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ArticleAdapter

    private val articleViewModel: ArticleViewModel by viewModels {
        ArticleViewModel.ArticleViewModelFactory((application as MyApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mService = Common.retrofitService
        binding.recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerMovieList.layoutManager = layoutManager

        getAllArticleList()

//        articleViewModel.allArticleItems.observe(this, {
//
//        })
    }

    private fun getAllArticleList()  {


        //println(mService.getArticlesList("us", "business"))
        mService.getArticlesList("us","business").enqueue(object : Callback<EntityResponse> {
            override fun onFailure(call: Call<EntityResponse>, t: Throwable) {
                println("FAIL     "+t.message)

            }

            override fun onResponse(call: Call<EntityResponse>, response: Response<EntityResponse>) {
                adapter = ArticleAdapter(baseContext, response.body() as EntityResponse)
//               println(response.body())
                binding.recyclerMovieList.adapter = adapter
                adapter.notifyDataSetChanged()

            }
        })
    }
}