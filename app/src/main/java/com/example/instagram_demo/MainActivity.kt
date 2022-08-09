package com.example.instagram_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram_demo.adapter.FeedAdapter
import com.example.instagram_demo.model.Feed
import com.example.instagram_demo.model.Post
import com.example.instagram_demo.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        recyclerView=findViewById(R.id.recyclerfeed)
        recyclerView.layoutManager=GridLayoutManager(this,1)
        refreshAdapter(getAllFeeds())
    }
    fun refreshAdapter(feed:ArrayList<Feed>){
        var adapter=FeedAdapter(this,feed)
        recyclerView.adapter=adapter
    }

    fun getAllFeeds():ArrayList<Feed>{
        var stories=ArrayList<Story>()

        stories.add(Story(R.drawable.user_1,"Ali"))
        stories.add(Story(R.drawable.user_2,"Sevindeik"))
        stories.add(Story(R.drawable.user_3,"Vali"))
        stories.add(Story(R.drawable.user_4,"Soliya"))
        stories.add(Story(R.drawable.user_1,"Ali"))
        stories.add(Story(R.drawable.user_2,"Sevindeik"))
        stories.add(Story(R.drawable.user_3,"Vali"))
        stories.add(Story(R.drawable.user_4,"Soliya"))

        var feeds=ArrayList<Feed>()
        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.user_2,"Sevindeik",R.drawable.car_3)))
        feeds.add(Feed(Post(R.drawable.user_1,"Ali",R.drawable.car_2)))
        feeds.add(Feed(Post(R.drawable.user_3,"Vali",R.drawable.car_1)))
        feeds.add(Feed(Post(R.drawable.user_4,"Soliya",R.drawable.car_4)))

        feeds.add(Feed(Post(R.drawable.user_4,"Soliha",R.drawable.car_4,R.drawable.car_2)))
        feeds.add(Feed(Post(R.drawable.user_4,"Solima",R.drawable.car_4,R.drawable.car_2,R.drawable.car_3)))
        return feeds

//
    }//
}