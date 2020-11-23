package com.codechallenge.nytimes

import com.codechallenge.nytimes.dao.datasource.ArticleDataSource
import com.codechallenge.nytimes.dao.repository.ArticleRepository
import com.codechallenge.nytimes.dao.repository.ArticleRepositoryImpl
import com.codechallenge.nytimes.domain.usecases.GetArticlesListUseCase
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KoinModules{

    private fun providesRetrofit(baseUrl: String,
                                 converterFactory: Converter.Factory) = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(converterFactory)
    }.build()

    private fun providesConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    val modules by lazy {
        module {
            single { providesRetrofit(BuildConfig.API_URL, providesConverterFactory()) }
            //define a singleton
            single { ArticleDataSource(get()) }
            single<ArticleRepository> { ArticleRepositoryImpl(get()) }
            single { GetArticlesListUseCase(get()) }
            viewModel { ArticlesListViewModel(get()) }
        }
    }
}
