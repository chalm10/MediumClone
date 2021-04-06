package com.example.mediumclone.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.Article
import com.example.mediumclone.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>> = _articles

    fun fetchGlobalFeed() {
        viewModelScope.launch {
            ArticlesRepo.getGlobalFeed()?.let {
                _articles.postValue(it.articles)
            }
        }
    }
//
//    private val _articles1 = MutableLiveData<List<Article>>().apply {
//        viewModelScope.launch {
//            value = ArticlesRepo.getGlobalFeed()?.articles
//            Log.d("FEED", "articles count = " + ArticlesRepo.getGlobalFeed()?.articlesCount.toString())
//        }
//
//    }




}