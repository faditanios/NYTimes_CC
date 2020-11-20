package com.codechallenge.nytimes

import com.codechallenge.nytimes.dao.repository.ArticleRepository
import com.codechallenge.nytimes.domain.ArticleDomain
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel
import org.koin.dsl.module

val appModule = module {
    //define a singleton
    single { ArticleRepository() }

    single { ArticleDomain(get()) }

    //create a new instance every time
    single { ArticlesListViewModel(get()) }
}