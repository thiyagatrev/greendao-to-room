package com.example.greendaotoroom.greendaodatabase

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.
/**
 * Entity mapped to table "MESSAGE".
 */
@Entity
class Message {
    @Id
    var id: Long? = null
    var mid: String? = null
    var msgTime: String? = null
    var msgType: String? = null

    @Generated
    constructor() {
    }

    constructor(id: Long?) {
        this.id = id
    }

    @Generated
    constructor(
        id: Long?,
        mid: String?,
        msgTime: String?,
        msgType: String?
    ) {
        this.id = id
        this.mid = mid
        this.msgTime = msgTime
        this.msgType = msgType
    }

}