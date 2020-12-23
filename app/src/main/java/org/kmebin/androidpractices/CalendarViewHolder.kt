package org.kmebin.androidpractices

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var date : TextView = itemView.findViewById(R.id.tv_day)
}