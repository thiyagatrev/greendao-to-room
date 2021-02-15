package com.example.greendao_generator

import org.greenrobot.greendao.generator.DaoGenerator

class GreendaoGenerator() : DaoGenerator() {

    companion object {

        @Throws(Exception::class)
        @JvmStatic
        fun main(vararg args: String) {
            val schema =
                org.greenrobot.greendao.generator.Schema(1, "com.example.greendaotoroom.database")
            val simple = schema.addEntity("Message")
            simple.addIdProperty()
            simple.addStringProperty("mid")
            simple.addStringProperty("msgTime")
            simple.addStringProperty("msgType")
            val daoGenerator = DaoGenerator()
            daoGenerator.generateAll(
                schema,
                "../greendaotoroom/app/src/main/java/com/example/greendaotoroom"
            )
        }
    }
}
