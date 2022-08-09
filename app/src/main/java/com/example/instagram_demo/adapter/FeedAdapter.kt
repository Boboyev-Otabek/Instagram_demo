package com.example.instagram_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram_demo.R
import com.example.instagram_demo.model.Feed
import com.example.instagram_demo.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var item: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        var type_story = 0
        var type_post = 1
        var type_post2 = 2
        var type_post3 = 3
    }

    override fun getItemViewType(position: Int): Int {
        if (item[position].stories.size > 0) return type_story
        if (item[position].post!!.photo_2 > 0 && item[position].post!!.photo_3== 0) return type_post2
        if (item[position].post!!.photo_3 > 0) return type_post3
        return type_post
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == type_story) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoriesViewHolder(context, view)
        } else if (viewType == type_post2) {
            var view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_post_2, parent, false)
            return Post2ViewHolder(view)
        } else if (viewType == type_post3) {
            var view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_post_3, parent, false)
            return Post3ViewHolder( view)
        }

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feed = item[position]


        if (holder is StoriesViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(recyclerView, feed.stories)
        }

        if (holder is PostViewHolder) {
            var profile = holder.profile
            var fullname = holder.fullname
            var photo = holder.photo
            profile.setImageResource(feed.post!!.profile)
            fullname.text = feed.post!!.fullname
            photo.setImageResource(feed.post!!.photo)
        }

        if(holder is Post2ViewHolder){
            var profile=holder.profile
            var fullname=holder.fullname
            var photo_1=holder.photo_1
            var photo_2=holder.photo_2

            profile.setImageResource(feed.post!!.profile)
            fullname.text=feed.post!!.fullname
            photo_1.setImageResource(feed.post!!.photo_1)
            photo_2.setImageResource(feed.post!!.photo_2)

        }

        if(holder is Post3ViewHolder){
            var profile=holder.profile
            var fullname=holder.fullname
            var photo_1=holder.photo_1
            var photo_2=holder.photo_2
            var photo_3=holder.photo_3

            profile.setImageResource(feed.post!!.profile)
            fullname.text=feed.post!!.fullname
            photo_1.setImageResource(feed.post!!.photo_1)
            photo_2.setImageResource(feed.post!!.photo_2)
            photo_3.setImageResource(feed.post!!.photo_3)
        }

    }

    fun refreshAdapter(recyclerView: RecyclerView, stories: ArrayList<Story>) {

        var adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    class StoriesViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerstory)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ShapeableImageView
        var fullname: TextView
        var photo: ImageView

        init {
            profile = view.findViewById(R.id.iv_post_profile)
            fullname = view.findViewById(R.id.post_fullname)
            photo = view.findViewById(R.id.iv_feed_post_photo)
        }
    }


    class Post2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ShapeableImageView
        var fullname: TextView
        var photo_1: ImageView
        var photo_2: ImageView

        init {
            profile = view.findViewById(R.id.iv_post2_profile)
            fullname = view.findViewById(R.id.post2_fullname)
            photo_1 = view.findViewById(R.id.iv_feed_post2_photo_1)
            photo_2 = view.findViewById(R.id.iv_feed_post2_photo_2)
        }
    }

    class Post3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ShapeableImageView
        var fullname: TextView
        var photo_1: ImageView
        var photo_2: ImageView
        var photo_3: ImageView
        init {
            profile=view.findViewById(R.id.iv_post3_profile)
            fullname=view.findViewById(R.id.post3_fullname)
            photo_1=view.findViewById(R.id.iv_feed_post3_photo_1)
            photo_2=view.findViewById(R.id.iv_feed_post3_photo_2)
            photo_3=view.findViewById(R.id.iv_feed_post3_photo_3)
        }

    }

}