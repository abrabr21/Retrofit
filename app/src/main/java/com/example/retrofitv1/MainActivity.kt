package com.example.retrofitv1

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitv1.Retrofit.RetrofitClient
import com.example.retrofitv1.Retrofit.RetrofitService
import com.example.retrofitv1.adapter.ArticleAdapter
import com.example.retrofitv1.common.Common
import com.example.retrofitv1.databinding.ActivityMainBinding
import com.example.retrofitv1.pojo.Article
import com.example.retrofitv1.pojo.Entity
import retrofit2.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ArticleAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mService = Common.retrofitService
        binding.recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerMovieList.layoutManager = layoutManager


        getAllMovieList()
           }

    private fun getAllMovieList() {


        println(mService.getArticlesList("us", "business"))
        mService.getArticlesList("us","business").enqueue(object : Callback<Entity> {
            override fun onFailure(call: Call<Entity>, t: Throwable) {
                println("FAIL     "+t.message)

            }

            override fun onResponse(call: Call<Entity>, response: Response<Entity>) {
//                adapter = ArticleAdapter(baseContext, response.body() as MutableList<Article>)
               println(response.body())
//                adapter.notifyDataSetChanged()
//                binding.recyclerMovieList.adapter = adapter


            }
        })
    }
}