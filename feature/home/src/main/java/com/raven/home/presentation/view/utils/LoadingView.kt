package com.raven.home.presentation.view.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.ProgressBar

class LoadingView (context: Context){
    private val dialog : AlertDialog

    init{
        val progressBar = ProgressBar(context)
        progressBar.isIndeterminate = true

        val build = AlertDialog.Builder(context)
        build.setView(progressBar)
        build.setCancelable(false)

        dialog = build.create()
    }

    fun showDialog() {
        dialog.show()
    }

    fun hideDialog() {
        dialog.hide()
    }
}