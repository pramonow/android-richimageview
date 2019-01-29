package com.pramonow.richimagetextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.Spannable
import android.widget.TextView
import android.widget.Toast
import com.pramonow.richimagetextviewmodule.HtmlImageRichText
import com.pramonow.richimagetextviewmodule.ImageClickInterface
import com.pramonow.richimagetextviewmodule.setClickListenerOnHtmlImageGetter


/*
 * Created by demidust on 9/18/18
 */

class MainActivity : AppCompatActivity(), ImageClickInterface {

    //Implement action for the images
    override fun onClick(imageSource:String) {
        Toast.makeText(this,"IMAGE CLICK " + imageSource,Toast.LENGTH_SHORT).show()
    }

    lateinit var richText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        richText = findViewById(R.id.text)

        //Html text for sample
        val detail = "<p> Rich image sample </p>" + "<td><a href=\"https://vignette.wikia.nocookie.net/universeconquest/images/e/e6/Sample.jpg/revision/latest?cb=20171003194302\"><img class=\"alignnone wp-image-133578 size-full colorbox-215\" src=\"https://vignette.wikia.nocookie.net/universeconquest/images/e/e6/Sample.jpg/revision/latest?cb=20171003194302\"></a></td>\n"

        //Creating the rich image text view
        val richTextWithImages = HtmlImageRichText(richText)
        val result: Spannable

        //Generate the spannable with images to be used later on
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(detail, Html.FROM_HTML_MODE_LEGACY) as Spannable
        } else {
            result = Html.fromHtml(detail, richTextWithImages, null) as Spannable
        }

        //setting click action on the images
        //result.setClickListenerOnHtmlImageGetter(this)

        //set the spannable result inside the text view
        richText.setText(result)
        richText.setMovementMethod(LinkMovementMethod.getInstance())
    }
}