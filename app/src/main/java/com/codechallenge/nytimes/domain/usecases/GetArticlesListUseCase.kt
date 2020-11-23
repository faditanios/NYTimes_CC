package com.codechallenge.nytimes.domain.usecases

import com.codechallenge.nytimes.dao.repository.ArticleRepository

class GetArticlesListUseCase(val articleRepository: ArticleRepository)
{
    suspend operator fun invoke() = articleRepository.getArticlesList()
}