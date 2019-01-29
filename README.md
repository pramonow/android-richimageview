# Rich Text View with images for android [![](https://jitpack.io/v/pramonow/android-richimageview.svg)](https://jitpack.io/#pramonow/android-richimageview)

Have you ever gotten into issue with your rich text view/html text and your images are not showing?
Now with this library it will be very easy for you to show it and set click action for it.

<img src="https://github.com/pramonow/just_images/blob/master/RichTextViewBefore.jpg" width="180"> ==> <img src="https://github.com/pramonow/just_images/blob/master/RichTextViewAfter.jpg" width="180">

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Dependency

	dependencies {
	        implementation 'com.github.pramonow:android-richimageview:-SNAPSHOT'
	}
  
# How to use

For the Android Activity

        //Normal text view
        var richText = findViewById<TextView>(R.id.text)

        //Rich image here
        val detail = "..html tag <images src = ...> .."

        //construct your html image rich text
        val imageGetter = HtmlImageRichText(richText)
        val result: Spannable

        //Generate your spannable
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(detail, Html.FROM_HTML_MODE_LEGACY, imageGetter,null) as Spannable
        } else {
            result = Html.fromHtml(detail, imageGetter, null) as Spannable
        }

        //set your click listener for the images
        result.setClickListenerOnHtmlImageGetter(object : ImageClickInterface {
            override fun onClick(imageSrc: String) {
                //image source can be obtained
            }

        })
        
        //set the spannable result
        richText.setText(result)
        richText.setMovementMethod(LinkMovementMethod.getInstance())

Now your image will be showing!
