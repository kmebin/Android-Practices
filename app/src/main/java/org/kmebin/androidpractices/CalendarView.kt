package org.kmebin.androidpractices

import android.util.Log
import java.util.*

class CalendarView {
    companion object {
        const val DAYS_OF_WEEK = 7
        var WEEKS_OF_MONTH = 5
    }

    private val calendar = Calendar.getInstance()
    init {
        calendar.time = Date()
    }

    var calendarData = arrayListOf<Int>()
    var thisMonthMaxDate = 0
    var lastMonthEndIndex = 0
    var nextMonthFirstIndex = 0

    // 캘린더 초기화
    // -> Calendar 값을 콜백 받고, return 값이 기본 Unit인 콜백 함수
    fun initCalendar(refreshCallback: (Calendar) -> Unit) {
        monthDate(refreshCallback)
    }

    // 지난 달로 이동했을 때 값 세팅
    fun lastMonth(refreshCallback: (Calendar) -> Unit) {
        if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER)
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1)
        } else
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1)
        monthDate(refreshCallback)
    }

    // 다음 달로 이동했을 때 값 세팅
    fun nextMonth(refreshCallback: (Calendar) -> Unit) {
        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY)
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+1)
        } else
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1)
        monthDate(refreshCallback)
    }

    // 현재 달력의 날짜 세팅
    private fun monthDate(refreshCallback: (Calendar) -> Unit) {
        calendarData.clear()

        // 기준 날 설정
        calendar.set(Calendar.DATE, 1)
        // 이번 달 1일의 요일
        val thisMonthFirstIndex = calendar.get(Calendar.DAY_OF_WEEK)
        // 이번 달의 말일
        thisMonthMaxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        // 지난 달 말일의 요일 (일요일 1, 토요일 7)
        lastMonthEndIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1

        lastMonthEnd(calendar.clone() as Calendar) // 캘린더 객체 복제
        thisMonthDate(calendar)

        // 이번 달 1일의 요일이 금요일 or 토요일인 경우 6주가 됨
        WEEKS_OF_MONTH = if (thisMonthFirstIndex == 6 || thisMonthFirstIndex == 7) 6
        else 5

        // 다음 달 1일의 요일
        nextMonthFirstIndex = DAYS_OF_WEEK * WEEKS_OF_MONTH - (lastMonthEndIndex+thisMonthMaxDate)
        nextMonthFirst()

        refreshCallback(calendar)
    }

    // 현재 달력에 이번 달의 날짜 데이터 생성
    private fun thisMonthDate(calendar: Calendar) {
        for (i in 1..calendar.getActualMaximum(Calendar.DATE))
            calendarData.add(i)
    }

    // 현재 달력에 지난 달의 날짜 데이터 생성
    private fun lastMonthEnd(calendar: Calendar) {
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        var maxDateIndex = maxDate - lastMonthEndIndex

        for (i in 1..lastMonthEndIndex)
            calendarData.add(++maxDateIndex)
    }

    // 현재 달력에 다음 달의 날짜 데이터 생성
    private fun nextMonthFirst() {
        var firstDate = 1

        for (i in 1..nextMonthFirstIndex)
            calendarData.add(firstDate++)
    }
}