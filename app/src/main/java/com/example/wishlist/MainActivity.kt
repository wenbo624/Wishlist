package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wishAdapter: listAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wishAdapter = listAdapter(mutableListOf())

        val rvwishlist = findViewById<RecyclerView>(R.id.rvwishlist)
        rvwishlist.adapter = wishAdapter
        rvwishlist.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.button)
        val wishname = findViewById<TextView>(R.id.Name)
        val inputprice = findViewById<TextView>(R.id.Price)
        val inputurl = findViewById<TextView>(R.id.url)

        button.setOnClickListener {
            val wishName = wishname.text.toString()
            val pricenum = inputprice.text.toString()
            val urlpath = inputurl.text.toString()
            if(wishName.isNotEmpty()){
                val item = Item(wishName, pricenum, urlpath)
                wishAdapter.addwish(item)
                wishname.text = ""
                inputprice.text = ""
                inputurl.text = ""

            }
        }
    }
}