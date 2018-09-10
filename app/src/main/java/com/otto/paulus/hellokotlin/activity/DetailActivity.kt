package com.otto.paulus.hellokotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.otto.paulus.hellokotlin.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        info(intent.getIntExtra("CLUB_INDEX",0))

        val clubIndex = intent.getIntExtra("CLUB_INDEX",0)

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)

        Glide.with(this).load(image.getResourceId(clubIndex,0)).into(iv_club_logo)
        tv_club_name.text = name[clubIndex]
        tv_club_description.text = description[clubIndex]

    }
}
