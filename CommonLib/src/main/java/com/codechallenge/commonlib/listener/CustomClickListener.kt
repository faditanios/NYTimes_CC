package com.codechallenge.commonlib.listener

import android.view.View

/**
 * Custom listener
 */
interface CustomClickListener
{
    fun onCustomClick(v: View?, obj: Any?, position: Int)
}