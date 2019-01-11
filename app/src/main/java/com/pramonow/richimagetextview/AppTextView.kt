package com.dev.demidust.promoapp.utility.image

import android.content.Context
import android.text.Html
import android.widget.TextView.BufferType
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.graphics.Paint.SUBPIXEL_TEXT_FLAG
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView


class AppTextView : TextView {

    lateinit var paint: Paint
    var addStrike = false

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //if (!isInEditMode) init(attrs)
    }

    constructor(context: Context) : super(context) {}

    override fun onDraw(canvas: Canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas)
        if (addStrike) {
            var w = width.toFloat()
            canvas.drawLine(0F, height / 2F, width.toFloat(), height / 2F, paint)
        }
    }

    override fun setText(text: CharSequence?, type: BufferType) {
        if (text != null) {
            super.setText(text, type)

        }
    }

    fun setHTMLText(value: String?) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            text = if (value != null) Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY) else ""
        } else {
            text = if (value != null) Html.fromHtml(value) else ""
        }
    }
}