package com.codechallenge.commonlib.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.codechallenge.commonlib.R

open class BaseActivity : AppCompatActivity()
{
    //region CALLBACK
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }
    //endregion

    //endregion
    //region Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        if (id == R.id.home)
        {
            //navigateUpTo(new Intent(this, ArticleListActivity.class));
            //return true;
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion
}