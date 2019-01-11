package com.pramonow.richimagetextview

import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.TextView
import com.dev.demidust.promoapp.utility.image.AppTextView
import com.squareup.picasso.Picasso

class PicassoImageGetter : Html.ImageGetter {

    private var textView: TextView? = null

    constructor(target: TextView) {
        textView = target
    }

    override fun getDrawable(source: String): Drawable {
        val drawable = BitmapDrawablePlaceHolder()
        drawable.setTextView(this.textView!!)

        Picasso.get()
            .load(source)
            .placeholder(R.color.material_grey_600).error(R.color.material_blue_grey_800)
            .into(drawable)

        return drawable
    }
}
