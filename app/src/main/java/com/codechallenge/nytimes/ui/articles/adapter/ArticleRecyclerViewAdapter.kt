package com.codechallenge.nytimes.ui.articles.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codechallenge.commonlib.base.BaseRecyclerViewAdapter
import com.codechallenge.commonlib.listener.CustomClickListener
import com.codechallenge.nytimes.R
import com.codechallenge.nytimes.databinding.ArticleListItemBinding
import com.codechallenge.nytimes.model.Article
import java.util.*

class ArticleRecyclerViewAdapter(private val customClickListener: CustomClickListener) :
    BaseRecyclerViewAdapter()
{
    /**
     * Thid custom listener will be used to handle the click on the recycler view
     */
    //private var onArticleClick: CustomClickListener? = null

    /**
     * ViewHolder setup with the needed initialization
     */
    class ArticleViewHolder(articleListItemBinding: ArticleListItemBinding) :
        RecyclerView.ViewHolder(articleListItemBinding.getRoot())
    {
        val articleListItemBinding: ArticleListItemBinding
        var iv_media: ImageView
        var mView: View
        var article: Article? = null

        init
        {
            mView = articleListItemBinding.getRoot()
            iv_media = mView.findViewById(R.id.iv_media)
            this.articleListItemBinding = articleListItemBinding
        }
    }

    /**
     * Using the Databinding
     * @param viewGroup
     * @param i
     * @return
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ArticleViewHolder
    {
        val articleListItemBinding: ArticleListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.article_list_item, viewGroup, false
        )
        return ArticleViewHolder(articleListItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        val articleViewHolder = holder as ArticleViewHolder
        articleViewHolder.article = mValues[position] as Article?
        articleViewHolder.articleListItemBinding.article = articleViewHolder.article

        //Loading the image in the image view
        articleViewHolder.article?.loadMedia(
            articleViewHolder.iv_media,
            R.drawable.ic_launcher_background
        )
        articleViewHolder.mView.setOnClickListener(View.OnClickListener {
            customClickListener.onCustomClick(
                null,
                articleViewHolder.article,
                position
            )
        })
    }

    //To filter the recyclerview data
    override fun filter(filter: String?)
    {
        clear()
        val filterLength = filter?.length ?: 0
        if (filterLength > 0)
        {
            var article: Article
            for (obj in mValuesAll)
            {
                article = obj as Article
                if (filter?.length == 0 || article.adxKeywords!!.toLowerCase(Locale.getDefault())
                        .contains(filter.toString())
                )
                {
                    mValues.add(article)
                }
            }
        } else
        {
            mValues.addAll(mValuesAll)
        }
        notifyDataSetChanged()
    }
}