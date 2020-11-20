package com.codechallenge.nytimes.ui.articles

import android.os.Bundle
import com.codechallenge.commonlib.base.BaseActivity
import com.codechallenge.nytimes.R
import kotlinx.android.synthetic.main.toolbar_layout.*

class ArticleActivity : BaseActivity()
{
    //var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(toolbar);
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }

}