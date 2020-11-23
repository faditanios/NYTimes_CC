package com.codechallenge.nytimes.domain.usecases

import com.codechallenge.nytimes.dao.repository.ArticleRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetArticlesListUseCase: KoinComponent
{
    private val articleRepository: ArticleRepository by inject()
    suspend operator fun invoke() = articleRepository.getArticlesList()
}