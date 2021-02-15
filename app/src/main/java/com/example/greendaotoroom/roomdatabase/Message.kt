package com.example.greendaotoroom.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity
data class Message(
    @ColumnInfo(name = "MID") var mid: String? = null,
    @ColumnInfo(name = "MSG_TIME") var msgTime: String? = null,
    @ColumnInfo(name = "MSG_TYPE") var msgType: String? = null
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id")
    var id: Int ?= null

}
