package com.codechallenge.nytimes

import com.codechallenge.nytimes.dao.repository.ArticleRepository
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel
import org.koin.dsl.module

val appModule = module {
    //define a singleton
    single { ArticleRepository() }

    //create a new instance every time
    single { ArticlesListViewModel(get()) }
}