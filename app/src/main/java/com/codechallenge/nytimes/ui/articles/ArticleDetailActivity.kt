package com.codechallenge.nytimes.ui.articles

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.model.Article
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * An activity representing a single Article detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ArticleListActivity].
 */
class ArticleDetailActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        setSupportActionBar(findViewById(R.id.detail_toolbar))
        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null)
        {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            var arguments = Bundle()
            val article: Article =
                intent.getSerializableExtra(ArticleDetailFragment.ARG_ARTICLE) as Article

            arguments.putSerializable(ArticleDetailFragment.ARG_ARTICLE, article)
            val fragment = ArticleDetailFragment()
            fragment.arguments = arguments

            supportFragmentManager.beginTransaction().add(R.id.article_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId)
        {
            android.R.id.home ->
            {
                finish();
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}