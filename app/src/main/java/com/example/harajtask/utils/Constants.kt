package com.example.harajtask.utils

import android.content.Context
import java.io.IOException

object Constants {
    const val JSON_FILE_NAME = "data.json"
    const val IS_TESTING = true
    const val TAG = "HarajTask"

    fun readJsonFomAssets(context: Context):String?{
        val jsonString:String
        try{
            jsonString =
                context
                    .assets
                    .open(JSON_FILE_NAME)
                    .bufferedReader()
                    .use { it.readText() }
        }catch (ioException:IOException){
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


}