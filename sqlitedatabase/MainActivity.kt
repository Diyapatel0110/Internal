package com.example.sqlitedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInsert.setOnClickListener {
            var name = edtFrname.text.toString()
            var desc = edtFrDesc.text.toString()
            var price = edtFrPrice.text.toString().toInt()
            var friut = Fruit(name, desc, price)
            var db=dbhelper(this)
            var flag= db.insert(friut)
            if(flag){
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        btnViewall.setOnClickListener {
            var intent=Intent(this,ViewAll::class.java)
            startActivity(intent)
        }
    }
}
