package com.pramonow.richimagetextviewmodule

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

class HtmlImageRichText(target: TextView) : Html.ImageGetter {

    private var textView: TextView? = target
    private var placeholderImage:Int = R.color.material_grey_600
    private var errorImage:Int = R.color.material_grey_600

    override fun getDrawable(source: String): Drawable {
        val drawable = BitmapDrawablePlaceHolder()
        drawable.setTextView(this.textView!!)

        //Using Picasso for loading image
        Picasso.get().load(source).placeholder(placeholderImage).error(errorImage).into(drawable)

        return drawable
    }

    /*
        Internal class for generating image placeholders
     */
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

        override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {

            val drawable = BitmapDrawable(Resources.getSystem(), bitmap)

            this.appDrawable = drawable
            val width = drawable.intrinsicWidth
            val height = drawable.intrinsicHeight
            drawable.setBounds(0, 0, width, height)
            setBounds(0, 0, width, height)
            sourceText.setText(sourceText.getText())
        }

        override fun onBitmapFailed(e: Exception, errorDrawable: Drawable) {

        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable) {

        }
    }

    /*
        Function to set image when network error happens
     */
    fun setErrorDrawable(errorImage: Int) {
        this.errorImage = errorImage
    }

    /*
        Function to set image before image has appeared
    */
    fun setPlaceholder(placeholderImage: Int) {
        this.placeholderImage = placeholderImage
    }
}


