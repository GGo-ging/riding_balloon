package com.example.riding_balloon.presentation.extensions

import android.content.Context
import android.widget.TextView
import com.example.riding_balloon.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun TextView.setPublishedDate(date: String) {
    text = date.convertDateFormat(this.context)
}

// 2024-08-14T21:55:36Z -> 1시간 전, 1일 전, 1주 전, 1개월 전, 1년 전
fun String.convertDateFormat(context: Context): String {
    val currentTime = System.currentTimeMillis()
    val publishTime = this.toDate().time
    val diffTime = currentTime - publishTime
    val diffSecond = diffTime / 1000
    val diffMinute = diffSecond / 60
    val diffHour = diffMinute / 60
    val diffDay = diffHour / 24
    val diffMonth = diffDay / 30
    val diffYear = diffMonth / 12

    with(context) {
        return when {
            diffYear > 0 -> getString(R.string.format_diff_year, diffYear)
            diffMonth > 0 -> getString(R.string.format_diff_month, diffMonth)
            diffDay > 0 -> getString(R.string.format_diff_day, diffDay)
            diffHour > 0 -> getString(R.string.format_diff_hour, diffHour)
            diffMinute > 0 -> getString(R.string.format_diff_minute, diffMinute)
            else -> getString(R.string.format_diff_second, diffSecond)
        }
    }
}

fun String.toDate(): Date {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.KOREA)
    return simpleDateFormat.parse(this) ?: Date()
}