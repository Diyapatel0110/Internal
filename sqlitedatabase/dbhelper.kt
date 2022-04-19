package com.example.sqlitedatabase

import android.app.DownloadManager
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf



class dbhelper(var context:Context)
    :SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        private var DB_NAME = "FruitDB"
        private var TB_NAME = "FruitDetail"
        private var DB_VERSION = 1
        private var FR_NAME = "fr_name"
        private var FR_ID = "id"
        private var FR_PRICE = "fr_price"
        private var FR_DESC = "fr_desc"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $TB_NAME($FR_ID INTEGER PRIMARY KEY AUTOINCREMENT"
        ",$FR_NAME TEXT, $FR_PRICE INTEGR, $FR_DESC TEXT, qty INTEGER)"
        p0?.execSQL(query);

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $TB_NAME IF EXISTS"
        p0?.execSQL(query);
        onCreate(p0)
    }
    fun insert(fruit: Fruit):Boolean{
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(FR_NAME,fruit.fr_name)
        cv.put(FR_DESC,fruit.fr_desc)
        cv.put(FR_PRICE,fruit.fr_price)
        var flag = db.insert(TB_NAME,null,cv)
        if (flag>0)
            return true
        else
            return false
    }
    fun retriveall() {
        var db=readableDatabase
        var cursor= db.query(TB_NAME,null,null,null,null,null,null)
        var arr:ArrayList<Fruit> = ArrayList()
        while(cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var name=cursor.getString(1)
            var desc=cursor.getString(2)
            var price=cursor.getInt(3)
            var fruit=Fruit(id,name,desc,price)
            arr.add(fruit)
        }
    }


}
