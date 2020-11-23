package com.codechallenge.nytimes

import com.codechallenge.nytimes.dao.datasource.ArticleDataSource
import com.codechallenge.nytimes.dao.repository.ArticleRepository
import com.codechallenge.nytimes.dao.repository.ArticleRepositoryImpl
import com.codechallenge.nytimes.domain.usecases.GetArticlesListUseCase
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { ArticlesListViewModel(get()) }

    //define a singleton
    single { ArticleDataSource() }

    single { GetArticlesListUseCase(get()) }

    single<ArticleRepository> { ArticleRepositoryImpl(get()) }
}