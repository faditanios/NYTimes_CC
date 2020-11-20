package com.codechallenge.commonlib.base

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.codechallenge.commonlib.R

open class BaseListFragment : Fragment()
{
    protected var adapter: BaseRecyclerViewAdapter? = null

    //region RecyclerView
    protected fun initRecyclerView(view: View, rvId: Int)
    {
        val recyclerView: RecyclerView = view.findViewById(rvId)!!
        recyclerView.adapter = adapter
    }

    fun addRecordsToRecyclerView(lst: ArrayList<Any>)
    {
        adapter?.addAll(lst)
        adapter?.notifyDataSetChanged()
    }
    //endregion

    var menuItemSearch: MenuItem? = null
    var searchView: SearchView? = null
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.common_list_menu, menu)
        menuItemSearch = menu.findItem(R.id.action_search)
        searchView = (menuItemSearch as MenuItem).actionView as SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String): Boolean
            {
                searchView?.let {
                    it.clearFocus()
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean
            {
                adapter?.let{
                    it.filter(newText)
                }
                return false
            }
        })
    }
    //endregion
}