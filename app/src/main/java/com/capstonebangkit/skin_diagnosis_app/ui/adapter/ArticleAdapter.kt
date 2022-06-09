package com.capstonebangkit.skin_diagnosis_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.ui.DataApiNews.Article

class ArticleAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var articles = arrayListOf<Article>()
    override fun getCount(): Int {
        return articles.size
    }

    override fun getItem(p0: Int): Any {
        return articles[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_newsarticle, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val articlee = getItem(position) as Article
        viewHolder.bind(articlee)

        return itemView
    }
    private inner class ViewHolder(view: View?) {
        val tvauthor = view?.findViewById<TextView>(R.id.list_tv_author)
        val tvjudul = view?.findViewById<TextView>(R.id.list_tv_article)
        val tvurl = view?.findViewById<TextView>(R.id.list_tv_url)

        fun bind(article: Article) {
            tvauthor?.text = article.author
            tvjudul?.text = article.title
            tvurl?.text = article.url
        }
    }
}