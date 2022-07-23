package com.project.pinjamin.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        private val monthName = listOf(
            "Januari",
            "Februari",
            "Maret",
            "April",
            "Mei",
            "Juni",
            "Juli",
            "Agustus",
            "September",
            "Oktober",
            "November",
            "Desember"
        )

        fun getMonthName(month: Int): String {
            return monthName[month]
        }
    }
}

fun Date.dateToString(format: String): String {
    //simple date formatter
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

    //return the formatted date string
    return dateFormatter.format(this)
}
