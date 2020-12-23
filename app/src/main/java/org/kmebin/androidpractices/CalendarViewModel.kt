package org.kmebin.androidpractices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

// ViewModel : UI 관련 데이터 보관, 관리
// -> 데이터의 소유권을 액티비티로부터 분리시킴
class CalendarViewModel : ViewModel() {

    // Calendar 클래스
    val calendar : Calendar = Calendar.getInstance()

    // MutableLiveData : 변경할 수 있는 LiveData 형
    // -> 데이터를 UI Thread와 Background Thread에서 선택적으로 바꿀 수 있음
    private val _year = MutableLiveData<Int>(calendar.get(Calendar.YEAR))
    private val _month = MutableLiveData<Int>(calendar.get(Calendar.MONTH)+1)

    // MutableLiveData를 LiveData로 발행
    val year : LiveData<Int>
        get() = _year
    val month : LiveData<Int>
        get() = _month

}