package com.team.delgram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.team.delgram.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var binding: ActivityHomePageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storyAdapter = StoryAdapter(listOf())
        binding.storiesRecycler.adapter = storyAdapter
        // not list fedd
        storyAdapter.notifyDataSetChanged()
    }
}