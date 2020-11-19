package com.codechallenge.nytimes.ui.articles

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.codechallenge.commonlib.base.BaseListActivity
import com.codechallenge.commonlib.listener.CustomClickListener
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.model.Article
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.ui.articles.adapter.ArticleRecyclerViewAdapter
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ArticleDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ArticleListActivity : BaseListActivity(), CustomClickListener//, CoroutineScope
{
    val TAG = "NYT"
    var viewModel: ArticlesListViewModel? = null

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = "Articles List"
        setSupportActionBar(toolbar);

        if (findViewById<NestedScrollView>(R.id.article_detail_container) != null)
        {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }
        initialize()

    }

    fun initialize()
    {
        initViews()
        initModelView()
        Log.e(TAG, "ArticleListActivity Thread Name : ${Thread.currentThread().name}")
        viewModel!!.search()
    }

    //endregion
    fun initViews()
    {
        adapter = ArticleRecyclerViewAdapter(this)
        initRecyclerView(R.id.article_list)
    }

    fun initModelView()
    {
        viewModel = ViewModelProvider(this).get(ArticlesListViewModel::class.java)
        viewModel!!.getResultLiveData()!!.observe(this, Observer<Any?>
        { articleResult ->
            updateUI(articleResult as ArticleResult)
        })
    }


    fun updateUI(articleResult: ArticleResult)
    {
        addRecordsToRecyclerView(articleResult.lstResults as ArrayList<Any>)
    }
    //endregion


    override fun onCustomClick(v: View?, obj: Any?, position: Int)
    {
        val article = obj as Article
        if (twoPane)
        {
            val arguments = Bundle()
            arguments.putSerializable(ArticleDetailFragment.ARG_ARTICLE, article)
            val fragment = ArticleDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                .replace(R.id.article_detail_container, fragment).commit()
        } else
        {
            val intent = Intent(this@ArticleListActivity, ArticleDetailActivity::class.java)
            intent.putExtra(ArticleDetailFragment.ARG_ARTICLE, article)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        return super.onCreateOptionsMenu(menu)
    }
}