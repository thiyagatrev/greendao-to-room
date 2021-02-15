package com.example.greendaotoroom.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MessageDao {

    @Insert
    fun insertMessage(message: Message)

    @Update
    fun updateMessage(message: Message)

    @Query("delete from Message where MID in (:mid)")
    fun deleteMessage(mid: String)

    @Query("select * from Message where MID in (:mid)")
    fun getMessage(mid: String) :Message?


}