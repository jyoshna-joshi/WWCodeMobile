package com.example.tasktracker

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

class TimeUtil {
    companion object {
        fun getDaysOfWeekShort(): List<String> {
            return DayOfWeek.values().map {
                it.getDisplayName(TextStyle.SHORT, Locale.getDefault())
            }
        }

        fun isToday(dayOfWeek: String): Boolean {
            val c = Calendar.getInstance().time
            val day = SimpleDateFormat("EE", Locale.getDefault()).format(c)
            return day == dayOfWeek
        }

        fun convertMillisToDate(millis: Long): String {
            val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            return formatter.format(Date(millis))
        }

        fun convertTime(time: Date): String {
            val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
            return formatter.format(time).toString()
        }

        fun calculateDuration(startTime: String, endTime: String): String {
            val format = android.icu.text.SimpleDateFormat("HH:mm", Locale.getDefault())
            return try {
                val start = format.parse(startTime)?.time ?: 0L
                val end = format.parse(endTime)?.time ?: 0L

                val durationInMinutes = (end - start) / (60 * 1000)
                durationInMinutes.toString()
            } catch (e: ParseException) {
                "0"
            }
        }
    }
}
