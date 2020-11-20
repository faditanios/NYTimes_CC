package com.codechallenge.nytimes.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.databinding.ArticleDetailBinding
import com.codechallenge.nytimes.model.Article
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A fragment representing a single Article detail screen.
 * on handsets.
 */
class ArticleDetailFragment : Fragment()
{

    /**
     * Article object to be displayed in the fragment
     */
    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_ARTICLE))
            {
                article = it.getSerializable(ARG_ARTICLE) as Article?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val binding: ArticleDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.article_detail, container, false
        )
        val view: View = binding.getRoot()
        article?.let {
            lifecycleScope.launch(Dispatchers.Main)
            {
                bindArticleInform(binding, it)
            }
        }
        return view
    }

    override fun onResume()
    {
        super.onResume()
        (activity as ArticleActivity)?.toolbar?.setTitle(getString(R.string.Article_Details))
    }

    suspend fun bindArticleInform(binding: ArticleDetailBinding, article: Article)
    {
        binding.article = article
    }

    companion object
    {
        /**
         * The fragment argument representing the Article ID that this fragment
         * represents.
         */
        const val ARG_ARTICLE = "article"
    }
}