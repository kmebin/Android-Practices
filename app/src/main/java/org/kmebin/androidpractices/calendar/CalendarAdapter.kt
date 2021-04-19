package org.kmebin.androidpractices.calendar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.kmebin.androidpractices.R
import java.util.*

class CalendarAdapter(private val calendarActivity: CalendarActivity) : RecyclerView.Adapter<CalendarViewHolder>() {
    private val calendarView =
        CalendarView()

    init {
        calendarView.initCalendar {
            refreshView(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day, parent, false)
        return CalendarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return CalendarView.DAYS_OF_WEEK * CalendarView.WEEKS_OF_MONTH
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        when {
            // 일요일 빨간색으로 설정
            position % CalendarView.DAYS_OF_WEEK == 0 -> holder.date.setTextColor(Color.RED)
            // 토요일 파란색으로 설정
            position % CalendarView.DAYS_OF_WEEK == 6 -> holder.date.setTextColor(Color.BLUE)
            else -> holder.date.setTextColor(Color.BLACK)
        }

        // 현재 달력에서 지난 달, 다음 달은 투명하게 설정
        if (position < calendarView.lastMonthEndIndex || position >= calendarView.lastMonthEndIndex+calendarView.thisMonthMaxDate)
            holder.date.alpha = 0.3f
        else holder.date.alpha = 1f

        holder.date.text = calendarView.calendarData[position].toString()
    }

    fun lastMonth() {
        calendarView.lastMonth {
            refreshView(it)
        }
    }

    fun nextMonth() {
        calendarView.nextMonth {
            refreshView(it)
        }
    }

    // 현재 달력의 데이터 새로고침
    private fun refreshView(calendar: Calendar) {
        notifyDataSetChanged()
        calendarActivity.refreshThisMonth(calendar)
    }
}