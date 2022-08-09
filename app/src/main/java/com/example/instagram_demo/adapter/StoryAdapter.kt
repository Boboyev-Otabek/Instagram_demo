package com.example.instagram_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram_demo.R
import com.example.instagram_demo.model.Feed
import com.example.instagram_demo.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context,var item:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return item.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var story=item[position]
        if(holder is StoryViewHolder){
            var profile=holder.iv_profile
            var fullname=holder.tv_fullname

            profile.setImageResource(story.profile)
            fullname.text=story.fullname
        }
    }
    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){

        var iv_profile:ShapeableImageView
        var tv_fullname:TextView

        init {
            iv_profile=view.findViewById(R.id.profile_story)
            tv_fullname=view.findViewById(R.id.fulname_story)
        }
    }
}