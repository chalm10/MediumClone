package com.example.mediumclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediumclone.R
import kotlinx.android.synthetic.main.fragment_feed.*

class GlobalFeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedViewModel.fetchGlobalFeed()
        feedViewModel.articles.observe(viewLifecycleOwner, {
            feedAdapter = FeedAdapter(it)
//            feedAdapter.notifyDataSetChanged()
            feedRecyclerView.apply {
                feedProgressBar.isVisible = false
                layoutManager = LinearLayoutManager(context)
                adapter = feedAdapter
            }
        })


    }


}