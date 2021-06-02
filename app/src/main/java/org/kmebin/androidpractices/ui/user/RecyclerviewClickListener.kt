package org.kmebin.androidpractices.ui.user

import android.view.View
import org.kmebin.androidpractices.data.model.Data

interface RecyclerviewClickListener {
    fun onItemClick(view: View, user: Data)
}