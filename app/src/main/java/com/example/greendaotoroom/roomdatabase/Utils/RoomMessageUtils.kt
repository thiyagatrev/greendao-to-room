package com.example.greendaotoroom.roomdatabase.Utils

import com.example.greendaotoroom.roomdatabase.AppDatabase
import com.example.greendaotoroom.roomdatabase.Message

object RoomMessageUtils {


    fun insertMessage(message: Message) =
        AppDatabase.getInstance().messageDao().insertMessage(message)

    fun updateMessage(message: Message) =
        AppDatabase.getInstance().messageDao().updateMessage(message)


    fun deleteMessage(mid: String) = AppDatabase.getInstance().messageDao().deleteMessage(mid)


    fun getMessage(mid: String) = AppDatabase.getInstance().messageDao().getMessage(mid)
}