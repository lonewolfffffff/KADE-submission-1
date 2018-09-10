package com.otto.paulus.hellokotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.otto.paulus.hellokotlin.Item
import com.otto.paulus.hellokotlin.R
import com.otto.paulus.hellokotlin.adapter.RecyclerViewAdapter
import com.otto.paulus.hellokotlin.anko.MainActivityUI
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivity : MainActivityUI

    private var items: MutableList<Item> = mutableListOf()

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivity = MainActivityUI()
        mainActivity.setContentView(this)

        initData()
        mainActivity.rv.layoutManager = LinearLayoutManager(this)
        mainActivity.rv.adapter = RecyclerViewAdapter(this, items) {
            startActivity<DetailActivity>("CLUB_INDEX" to items.indexOf(it))
        }
    }
}
