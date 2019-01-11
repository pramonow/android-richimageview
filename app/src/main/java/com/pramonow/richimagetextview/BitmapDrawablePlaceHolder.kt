package com.pramonow.richimagetextview

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.squareup.picasso.Target
import android.content.res.Resources
import android.util.Log
import android.widget.TextView
import com.dev.demidust.promoapp.utility.image.AppTextView
import com.squareup.picasso.Picasso

class BitmapDrawablePlaceHolder : BitmapDrawable(), Target {

    var appDrawable: Drawable? = null
    lateinit var appTextView:TextView

    fun setTextView(appTextView: TextView) {
        this.appTextView = appTextView
    }

    override fun draw(canvas: Canvas) {

        if (appDrawable != null) {
            appDrawable!!.draw(canvas)
        }
    }

    fun setDrawable(drawable: Drawable) {
        this.appDrawable = drawable
        val width = drawable.intrinsicWidth
        val height = drawable.intrinsicHeight
        drawable.setBounds(0, 0, width, height)
        setBounds(0, 0, width, height)
        appTextView.setText(appTextView.getText())
    }


    override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
        setDrawable(BitmapDrawable(Resources.getSystem(), bitmap))
    }

    override fun onBitmapFailed(e: Exception, errorDrawable: Drawable) {
    }

    override fun onPrepareLoad(placeHolderDrawable: Drawable) {

    }
}