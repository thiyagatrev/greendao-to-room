package com.example.greendaotoroom.greendaodatabase

import com.example.greendaotoroom.MobileApplication

class MessageDataManager {

    fun insertMessage(message: Message){
        val daoSession: MessageDao? = MobileApplication.daoSession?.messageDao
        daoSession?.insert(message)
    }

    fun updateMessage(message: Message){
        val daoSession: MessageDao? = MobileApplication.daoSession?.messageDao
        daoSession?.update(message)
    }

    fun deleteMessage(mid: String) {
      MobileApplication.daoSession?.queryBuilder(MessageDao::class.java)?.where(MessageDao.Properties.Mid.eq(mid))?.buildDelete()
    }
}