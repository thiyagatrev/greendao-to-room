package com.example.greendaotoroom.greendaodatabase.Utils

import com.example.greendaotoroom.greendaodatabase.Message
import com.example.greendaotoroom.greendaodatabase.MessageDataManager

object GreendaoMessageUtils {

    fun insertMessage(message: Message) {
        MessageDataManager().insertMessage(message)
    }

    fun updateMessage(message: Message) {
        MessageDataManager().updateMessage(message)
    }

    fun deleteMessage(mid: String) {
        MessageDataManager().deleteMessage(mid)
    }

}