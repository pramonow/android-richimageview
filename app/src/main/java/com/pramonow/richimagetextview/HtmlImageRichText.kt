package com.pramonow.richimagetextview

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.text.Spannable
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ImageSpan
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

class HtmlImageRichText : Html.ImageGetter {

    private var textView: TextView? = null
    private var placeholderImage:Int = R.color.material_grey_600
    private var errorImage:Int = R.color.material_grey_600

    constructor(target: TextView) {
        textView = target
    }

    override fun getDrawable(source: String): Drawable {
        val drawable = BitmapDrawablePlaceHolder()
        drawable.setTextView(this.textView!!)

        Picasso.get().load(source).placeholder(placeholderImage)
            .error(errorImage).into(drawable)

        return drawable
    }

    fun setErrorDrawable(errorDrawableRes: Int) {
        this.errorImage = errorImage
    }

    fun setPlaceholder(placeholderImage: Int) {
        this.placeholderImage = placeholderImage
    }

    internal class BitmapDrawablePlaceHolder : BitmapDrawable(), Target {

        var appDrawable: Drawable? = null
        lateinit var sourceText:TextView

        fun setTextView(textView: TextView) {
            this.sourceText = textView
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
            sourceText.setText(sourceText.getText())
        }


        override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
            setDrawable(BitmapDrawable(Resources.getSystem(), bitmap))
        }

        override fun onBitmapFailed(e: Exception, errorDrawable: Drawable) {

        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable) {

        }
    }

}

fun Spannable.setClickListenerOnHtmlImageGetter( callback: ImageClickInterface) {
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
