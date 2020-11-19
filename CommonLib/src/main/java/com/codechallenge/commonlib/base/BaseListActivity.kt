package com.codechallenge.commonlib.base

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.codechallenge.commonlib.R

open class BaseListActivity: BaseActivity()
{
    protected var adapter: BaseRecyclerViewAdapter? = null

    //region RecyclerView
    protected fun initRecyclerView(rvId: Int)
    {
        val recyclerView: RecyclerView = findViewById(rvId)!!
        recyclerView.adapter = adapter
    }

    fun addRecordsToRecyclerView(lst: ArrayList<Any>)
    {
        adapter?.addAll(lst)
        adapter?.notifyDataSetChanged()
    }
    //endregion

    //endregion
    //region Menu
    var menuItemSearch: MenuItem? = null
    var searchView: SearchView? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        val inflater = menuInflater
        inflater.inflate(R.menu.common_list_menu, menu)
        menuItemSearch = menu.findItem(R.id.action_search)
        searchView = (menuItemSearch as MenuItem).actionView as SearchView
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String): Boolean
            {
                searchView!!.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean
            {
                adapter?.filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    //endregion
}