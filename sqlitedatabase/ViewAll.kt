package com.example.sqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.FruitAdapter
import com.example.sqlitedatabase.R.layout.activity_view_all
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_view_all)
        updateRecyclarView()
    }
    private fun updateRecyclarView(){
        var db=dbhelper(this)
        var arr=db.retriveall()
        var adapter=FruitAdapter(this, myarr = arrayListOf())
        myrecycle.adapter=adapter
    }
}