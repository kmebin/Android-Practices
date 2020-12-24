package org.kmebin.androidpractices

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_calendar.*
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
	private lateinit var calendarAdapter: CalendarAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_calendar)

		calendarAdapter = CalendarAdapter(this)

		rv_calendar.adapter = calendarAdapter
		rv_calendar.layoutManager = GridLayoutManager(this, CalendarView.DAYS_OF_WEEK)

		// 가로선 추가
		val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
		dividerItemDecoration.setDrawable(this.resources.getDrawable(R.drawable.calendar_divider))
		rv_calendar.addItemDecoration(dividerItemDecoration)

		// 이전 달로 이동 버튼 세팅
		btn_last_month.setOnClickListener {
			calendarAdapter.lastMonth()
		}

		// 다음 달로 이동 버튼 세팅
		btn_next_month.setOnClickListener {
			calendarAdapter.nextMonth()
		}
	}

	// 현재 달력 새로 고침
	fun refreshThisMonth(calendar: Calendar) {
		val dateFormat = SimpleDateFormat("yyyy. MM", Locale.KOREAN)
		tv_header.text = dateFormat.format(calendar.time)
	}
}