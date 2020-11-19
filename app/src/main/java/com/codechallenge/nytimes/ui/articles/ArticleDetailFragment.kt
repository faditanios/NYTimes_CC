package com.codechallenge.nytimes.ui.articles

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.databinding.ArticleDetailBinding
import com.codechallenge.nytimes.model.Article
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ArticleListActivity]
 * in two-pane mode (on tablets) or a [ArticleDetailActivity]
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
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                article = arguments!!.getSerializable(ARG_ARTICLE) as Article?
                val activity: Activity? = this.activity
                val appBarLayout: CollapsingToolbarLayout = activity!!.findViewById(R.id.toolbar_layout)
                if (appBarLayout != null)
                {
                    appBarLayout.title = article!!.source
                }
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
        if (article != null)
        {
            binding.article = article
        }
        return view
    }

    companion object
    {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ARTICLE = "article"
    }
}