package com.example.greendaotoroom

import android.app.Application
import android.content.Context
import com.example.greendaotoroom.greendaodatabase.DaoMaster
import com.example.greendaotoroom.greendaodatabase.DaoMaster.DevOpenHelper
import com.example.greendaotoroom.greendaodatabase.DaoSession
import com.example.greendaotoroom.roomdatabase.AppDatabase
import com.facebook.stetho.Stetho


class MobileApplication : Application() {


    private val TAG = "MobileApplication"
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        val devOpenHelper = DevOpenHelper(context, "greedao-to-room", null)
        val db = devOpenHelper.writableDatabase
        val daoMaster = DaoMaster(db)
//        daoSession = daoMaster.newSession()
        AppDatabase.initDatabase(this)
        Stetho.initializeWithDefaults(this)
    }

    companion object {
        @JvmStatic
        lateinit var daoSession: DaoSession

        @JvmStatic
        lateinit var context: Context

    }
}