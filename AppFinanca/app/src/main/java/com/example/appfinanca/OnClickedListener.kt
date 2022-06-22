package com.example.appfinanca

import android.view.View

interface OnClickedListener {
    fun onItemClicked(view: View,
                      position:Int)
    fun onItemLongClicked(view: View,
                          position:Int)
}