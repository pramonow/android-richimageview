package com.pramonow.richimagetextviewmodule

import android.text.Spannable
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ImageSpan
import android.view.View

// Extension function for spannable, used in order to set callback for the image
fun Spannable.setClickListenerOnHtmlImageGetter(callback: ImageClickInterface) {
    val image_spans = this.getSpans(0, this.length, ImageSpan::class.java)

    for (span in image_spans) {
        val imageSource = span.getSource()
        val start = this.getSpanStart(span)
        val end = this.getSpanEnd(span)

        val clickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                callback.onClick(imageSource)
            }
        }

        val clickSpans = this.getSpans(start, end, ClickableSpan::class.java)

        if (clickSpans.size != 0) {
            // remove all click spans
            for (span in clickSpans) {
                this.removeSpan(span)
            }
        }

        this.setSpan(clickSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}