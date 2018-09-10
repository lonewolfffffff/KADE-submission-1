package com.otto.paulus.hellokotlin.anko

import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.otto.paulus.hellokotlin.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI : AnkoComponent<MainActivity> {

    lateinit var rv : RecyclerView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            rv = recyclerView{
                lparams(width= matchParent,height = matchParent)
            }

        }
    }
}