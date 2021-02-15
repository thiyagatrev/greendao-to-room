package com.example.greendaotoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.greendaotoroom.greendaodatabase.Utils.GreendaoMessageUtils
import com.example.greendaotoroom.greendaodatabase.Message
import com.example.greendaotoroom.roomdatabase.Utils.RoomMessageUtils
import java.lang.System.nanoTime

class MainActivity : AppCompatActivity() {

    lateinit var editText:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=findViewById(R.id.edt_input)
        val model: MainViewModel by viewModels()

        findViewById<Button>(R.id.btn_insert_data).setOnClickListener {
            val message=Message()
            message.mid= editText.text.toString()
            message.msgTime= nanoTime().toString()
            message.msgType= nanoTime().toString()
            GreendaoMessageUtils.insertMessage(message)
        }

        findViewById<Button>(R.id.btn_delete_data).setOnClickListener {

            GreendaoMessageUtils.deleteMessage(findViewById<EditText>(R.id.edt_input).text.toString())
        }

        findViewById<Button>(R.id.btn_insert_room_data).setOnClickListener {

            val message=com.example.greendaotoroom.roomdatabase.Message(
                editText.text.toString() ,
                msgTime= nanoTime().toString() ,
                msgType= nanoTime().toString())
            model.insertMessage(message)
        }

        findViewById<Button>(R.id.btn_delete_room_data).setOnClickListener {
            RoomMessageUtils.deleteMessage(findViewById<EditText>(R.id.edt_input).text.toString())
        }


    }
}