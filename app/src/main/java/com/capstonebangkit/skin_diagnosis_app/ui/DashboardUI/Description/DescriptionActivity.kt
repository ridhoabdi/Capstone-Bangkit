package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Description

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityDescriptionBinding
import com.capstonebangkit.skin_diagnosis_app.ui.DataApiNews.Article
import com.capstonebangkit.skin_diagnosis_app.ui.adapter.ArticleAdapter
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class DescriptionActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArticleAdapter
    private lateinit var articless: ArrayList<Article>

    private lateinit var binding: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        listView = findViewById(R.id.lv_Article)
        adapter = ArticleAdapter(this)
        articless = parseJSON()

        listView.adapter = adapter
        adapter.articles = articless

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            val toast = Toast.makeText(this, articless[i].author, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun parseJSON(): ArrayList<Article> {
        val articlees = arrayListOf<Article>()
        var json: String? = null

        try {
            val input: InputStream = assets.open("response.json")
            json = input.bufferedReader().use { it.readText() }

            // Mengambil object terluar pada file JSON
            val jsonObject = JSONObject(json)

            // Mengambil array dengan kunci "employees" dari jsonObject
            val jsonArray = jsonObject.getJSONArray("articles")

            // Melakukan perulangan untuk mengambil object employee dari jsonArray
            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)

                val penulis: String = jsonObj.getString("author")
                val judul: String = jsonObj.getString("title")
                val url: String = jsonObj.getString("url")

                val employee = Article(penulis, judul, url)

                articlees.add(employee)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return articlees
    }
}