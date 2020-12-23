package org.kmebin.androidpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import org.kmebin.androidpractices.databinding.ActivityCalendarBinding

class CalendarActivity : AppCompatActivity() {

	private val calendarViewModel : CalendarViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// DataBinding 사용
		// -> UI 컴포넌트마다 각각 findViewById를 선언해 주지 않아도 됨
		// 1. bulid.gradle에 dataBinding 선언
		// 2. layout.xml 최상위 루트에 <layout> 태그 추가
		// 3. setContentView(R.layout.activity_main)
		// 	  -> DataBindingUtil.setContentView(this, R.layout.activity_main)으로 변경
		val binding : ActivityCalendarBinding = DataBindingUtil.setContentView(this, R.layout.activity_calendar)
		binding.calendarViewModel = calendarViewModel
		binding.lifecycleOwner= this
	}
}