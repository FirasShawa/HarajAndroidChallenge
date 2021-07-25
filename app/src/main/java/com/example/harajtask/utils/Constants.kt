package com.example.harajtask.utils

import android.content.Context
import android.util.Log
import java.io.IOException
import java.text.SimpleDateFormat

object Constants {
    const val TAG = "HarajTask"

    const val JSON_FILE_NAME = "data.json"
    const val IS_TESTING = true

    const val DATE_TEXT_TEMPLATE = "Since "

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

    private fun getDate(s: Long): java.util.Date {
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        val netDate = java.util.Date(s * 1000)
        return netDate
    }

    fun ParceTimeStamp(longDate: Long):String{
        var date1 = java.util.Date(System.currentTimeMillis());
        var date2 = getDate(longDate)
        val diff: Long = date1.getTime() - date2.getTime()
        val seconds = Math.abs(diff) / 1000
        val minutes = Math.abs(seconds) / 60
        val hours = Math.abs(minutes) / 60
        val days = Math.abs(hours) / 24
        var result = ""
        if(Constants.IS_TESTING){
            Log.d(Constants.TAG, "$hours:$minutes:$seconds days $days")
        }

        result = when {
            seconds < 60 -> {
                "$seconds seconds"
            }
            minutes < 60 -> {
                "$minutes minutes"
            }
            hours< 24 -> {
                "$hours hours"
            }
            else -> {
                "$days days"
            }
        }

        return "${Constants.DATE_TEXT_TEMPLATE}$result"
    }

}