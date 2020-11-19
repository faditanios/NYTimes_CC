package com.codechallenge.commonlib.base

import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

abstract class BaseRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    val mValues = ArrayList<Any>()
    val mValuesAll = ArrayList<Any>()

    override fun getItemCount(): Int
    {
        return mValues.size
    }

    open fun addAll(lst: ArrayList<Any>)
    {
        mValues.addAll(lst)
        mValuesAll.addAll(lst)
    }

    open fun clear()
    {
        mValues.clear()
    }

    open fun filter(filter: String?)
    {

    }

}