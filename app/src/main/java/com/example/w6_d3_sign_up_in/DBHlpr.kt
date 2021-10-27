package com.example.w6_d3_sign_up_in

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr(context: Context?) : SQLiteOpenHelper(context, "users.db", null, 1) {

    var sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            //Create the Database
            db.execSQL("create table users_info (Phone text PRIMARY KEY, Name text, Location text, Password text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedata(phone : String, name : String, location : String, password : String): Long{
        //Adding data to content holder
        val cv = ContentValues()
        cv.put("Phone",phone)
        cv.put("Name",name)
        cv.put("Location",location)
        cv.put("Password",password)
        var status = sqLiteDatabase.insert("users_info",null, cv)
        return status
    }

    @SuppressLint("Range")
    fun retrive(phone: String) : String {
        var c : Cursor = sqLiteDatabase.query("users_info", null, "Phone=?",
            arrayOf(phone), null, null, null)
        if (c.count < 1) {
            return "user not exists"
        }
        c.moveToFirst()

        var name = c.getString(c.getColumnIndex("Name"))
        var loc = c.getString(c.getColumnIndex("Location"))
        var result = "$name\n$loc"
        return result
    }

    @SuppressLint("Range")
    fun checkUser(phone: String, password: String) : String {
        var c : Cursor = sqLiteDatabase.query("users_info", null,
            "Phone=?",
            arrayOf(phone), null, null, null)
        if (c.count < 1) {
            return "user not exists"
        }
        c.moveToFirst()

        var pass = c.getString(c.getColumnIndex("Password"))
        if (pass == password)
            return "user found"
        else
            return "user not exists"
    }
}