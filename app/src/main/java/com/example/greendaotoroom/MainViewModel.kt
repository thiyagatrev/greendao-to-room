package com.example.greendaotoroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greendaotoroom.roomdatabase.Message
import com.example.greendaotoroom.roomdatabase.Utils.RoomMessageUtils

class MainViewModel : ViewModel() {

    var roomMessageUtils: RoomMessageUtils = RoomMessageUtils

    var mtempMessage: MutableLiveData<Message>?=null

    fun insertMessage(message: Message) {
        roomMessageUtils.insertMessage(message)
        this.mtempMessage?.value = roomMessageUtils.getMessage(message.mid.toString())

    }
    fun updateMessage(message: Message) {
        roomMessageUtils.updateMessage(message)
    }



    fun deleteMessage(mid: String) {
        roomMessageUtils.deleteMessage(mid)
    }

}