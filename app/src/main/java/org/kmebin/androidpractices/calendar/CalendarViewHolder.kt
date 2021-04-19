package org.kmebin.androidpractices.calendar

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.kmebin.androidpractices.R

class CalendarViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var date : TextView = itemView.findViewById(R.id.tv_day)
}