package com.codechallenge.nytimes.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.codechallenge.commonlib.base.BaseListFragment
import com.codechallenge.commonlib.listener.CustomClickListener
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.model.Article
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.ui.articles.adapter.ArticleRecyclerViewAdapter
import com.codechallenge.nytimes.ui.articles.viewmodel.ArticlesListViewModel
import com.codechallenge.nytimes.util.api.State
import com.codechallenge.nytimes.util.api.Status
import kotlinx.android.synthetic.main.article_list.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import org.koin.android.ext.android.get

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleListFragment : BaseListFragment(), CustomClickListener
{
    val viewModel = get<ArticlesListViewModel>()
    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_article_list, container, false)
        initialize();
        return rootView
    }

    override fun onResume()
    {
        super.onResume()
        (activity as ArticleActivity).toolbar?.setTitle(getString(R.string.Articles_List))
    }

    fun initialize()
    {
        initViews()
        initModelView()
    }

    fun initViews()
    {
        adapter = ArticleRecyclerViewAdapter(this)
        rootView?.let { initRecyclerView(it, R.id.article_list) }
    }

    fun initModelView()
    {
        viewModel.result.observe(viewLifecycleOwner, ::updateUI)
    }

    private fun updateUI(articleData: State<ArticleResult>)
    {
        when (articleData.responseType)
        {
            Status.ERROR ->
            {
                hideProgress()
                articleData.error?.message?.let { showMessage(it) }
            }
            Status.LOADING ->
            {
                showProgress()
            }
            Status.SUCCESSFUL ->
            {
                hideProgress()
                articleData.data?.let {
                    addRecordsToRecyclerView(it.lstResults as ArrayList<Any>)
                }
            }
        }
    }

    private fun showProgress()
    {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress()
    {
        progressBar.visibility = View.GONE
    }

    private fun showMessage(message: String)
    {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    private fun updateUI(articleResult: ArticleResult)
    {
        addRecordsToRecyclerView(articleResult.lstResults as ArrayList<Any>)
    }

    override fun onCustomClick(v: View?, obj: Any?, position: Int)
    {
        val article = obj as Article
        rootView?.let {
            val bundle = bundleOf(ArticleDetailFragment.ARG_ARTICLE to article)
            Navigation.findNavController(it).navigate(R.id.navigate_to_details, bundle)
        }

    }
}