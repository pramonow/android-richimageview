package com.pramonow.richimagetextview

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.FrameLayout
import com.dev.demidust.promoapp.utility.image.AppTextView
import android.text.style.URLSpan
import android.text.style.ImageSpan
import android.text.Spannable
import android.text.style.ClickableSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast



/*
 * Created by demidust on 9/18/18
 */

class MainActivity : AppCompatActivity(), ImageClickInterface {
    override fun onClick() {
        Log.d("baniman", "CLICK CLICK CLICK")
    }

    lateinit var richText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        richText = findViewById(R.id.text)

        val detail = "<p style=\"text-align: justify;\"><a href=\"http://katalogpromosi.com/Giant\"><strong>Promo Giant &#x2013; Katalog GIANT </strong></a>Weekend Promo! Dapatkan berbagai informasi dan promosi menarik dalam Katalog Belanja dan Promosi Weekend Promo periode 11-13 Januari 2019<span id=\"more-215\"></span></p><p>Promo Giant Ekstra dan Giant Ekspres Periode 11 Januari &#x2013; 13 Januari 2019</p><ul>\n" +
                "<li>Apel Fuji RRC Rp. 2.450,-/100 gr</li>\n" +
                "<li>Tropical Minyak Goreng Pouch 2 lt Rp. 21.700,-</li>\n" +
                "<li>Rinso Deterjen Bubuk 800 gr Rp. 15.900,-</li>\n" +
                "<li>Giant/Sus Gula Pasir Lokal Premium 1 kg Rp. 11.200,-</li>\n" +
                "<li>Jeruk Mandarin Pakistan Rp. 1.450,-/100 gr</li>\n" +
                "<li>Jambu Crystal Sunpride Rp. 1.990,-/100 gr Rp. 1.990,-/100 gr</li>\n" +
                "<li>Edamame Lokal Rp. 2.190,-/100 gr</li>\n" +
                "<li>Bawang Bombay Gelar Rp. 1.690,-/100 gr</li>\n" +
                "<li>Ati Sapi Rp. 3.850,-/100 gr (Promo Tidak Berlaku di Jawa Timur)</li>\n" +
                "<li>Ayam Broiler Rp. 28.400,-/ekor</li>\n" +
                "<li>Ikan Gurame Hidup Rp. 4.850,-/100 gr</li>\n" +
                "<li>Beli 2 Gratis 1 Marble Cake Log Rp. 11.000,-/pc (200 gr) Rp. 23.000,-/pc (200 gr)</li>\n" +
                "<li>Hemat 20% Produk Daging Olahan (Berlaku Untuk Produk Tertentu) Bernardi/Belfoods/Sumber Selera/So Good/Kimbo</li>\n" +
                "<li>Hemat 20% Produk Keju Olahan (Berlaku Untuk Produk Tertentu) Prochiz/Meg Cheddar/Kraft</li>\n" +
                "<li>Hemat 15% Prodk Sambal (Berlaku Untuk Produk Tertentu) ABC/Indofood/Belibis/Sasa/Del Monte</li>\n" +
                "<li>Chitato Rasa Sapi Panggang 68 gr Rp. 8.700,-</li>\n" +
                "<li>Minute Maid Pulpy Orange/Orage Mango/Aloevera/Tropical 300 ml Rp. 5.500,-</li>\n" +
                "<li>Hemat 10% Produk Sereal (Berlaku Untuk Produk Tertentu) Simba/Entrasol/Energen/Quaker/Koko Krunch</li>\n" +
                "<li>Hemat 10% Produk Susu UHT 1 lt (Berlaku Untuk Produk Tertentu) Indomilk/Greenfields/Diamond/Frisian Flag</li>\n" +
                "<li>Hemat 10% Produk Susu Hi-Cal (Berlaku Untuk Produk Tertentu) Entrasol/Anlene/Produgen</li>\n" +
                "<li>Hemat 20% Produk Pembalut (Berlaku Untuk Produk Tertentu) Charm/Laurier</li>\n" +
                "<li>Hemat 30% Giant Tisu Wajah 200&#x2019;s Rp. 6.400,-</li>\n" +
                "<li>Clear Shampoo 160 ml/170 ml (Semua Jenis) Rp. 16.900,-</li>\n" +
                "<li>Pond&#x2019;s Facial Foam 100 gr (Semua Jenis) Rp. 19.200,-</li>\n" +
                "<li>Baygon Aerosol Tea Blossom/Flower Garden 600 ml Rp. 25.900,-</li>\n" +
                "<li>Beli 1 Gratis 1 Alexa Bantal/Guling Rp. 49.900,- (Promo Hanya Berlaku di Giant Ekstra)</li>\n" +
                "<li>Hemat 20% Semua Pakaian Dalam Pria (Crocodile/GT Man/Rider)</li>\n" +
                "</ul><p>Keterangan:<br>\n" +
                "&#x2013; Giant berhak membatasi pembelian.<br>\n" +
                "&#x2013; Tidak berlaku untuk trader.<br>\n" +
                "&#x2013; Produk fresh hanya berlaku di Jawa, Bali, Lampung, Palembang dan Bangka</p><p>Untuk katalog GIANT Weekend periode 11-13 Januari 2019 selengkapnya, silahkan lihat gambar di atas (<em>klik untuk memperbesar</em>)</p><ul>\n" +
                "<li>Jangan Lewatkan juga Katalog GIANT EKSTRA periode 03-22 Januari 2019. <a href=\"http://katalogpromosi.com/pasar-swalayan/katalog-giant-ekstra-promo-terbaru\">Untuk selengkapnya, dapat dilihat disini </a></li>\n" +
                "<li>Sedangkan untuk Katalog GIANT EKSPRES terbaru periode 03-22 Januari 2019,<a href=\"http://katalogpromosi.com/pasar-swalayan/katalog-giant-ekspres-super-hemat\"> dapat dilihat selengkapnya disini </a></li>\n" +
                "</ul><table border=\"0\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td><a href=\"http://katalogpromosi.com/pasar-swalayan/katalog-giant-ekstra-promo-terbaru\"><img class=\"alignnone wp-image-133578 size-full colorbox-215\" src=\"http://katalogpromosi.com/wp-content/uploads/2016/11/banner_katalog_ekstra.png\" alt=\"banner_katalog_ekstra\" width=\"330\" height=\"330\"></a></td>\n" +
                "<td><a href=\"http://katalogpromosi.com/pasar-swalayan/katalog-giant-weekend-promo\"><img class=\"alignnone wp-image-133579 size-full colorbox-215\" src=\"http://katalogpromosi.com/wp-content/uploads/2016/11/banner_katalog_koran.png\" alt=\"banner_katalog_koran\" width=\"330\" height=\"330\"></a></td>\n" +
                "<td><a href=\"http://katalogpromosi.com/pasar-swalayan/katalog-giant-ekspres-promo-terbaru\"><img class=\"alignnone wp-image-133577 size-full colorbox-215\" src=\"http://katalogpromosi.com/wp-content/uploads/2016/11/banner_katalog_ekspres.png\" alt=\"banner_katalog_ekspres\" width=\"330\" height=\"330\"></a></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table><p>Untuk katalog Weekend lainnya (periode 11-13 Januari 2019), <a href=\"http://katalogpromosi.com/tag/katalog-weekend-11-13-januari-2019\">dapat dilihat disini</a></p>"

        val imageGetter = PicassoImageGetter(richText)
        val result: Spanned
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(detail, Html.FROM_HTML_MODE_LEGACY, imageGetter,null) as Spannable
        } else {
            result = Html.fromHtml(detail, imageGetter, null) as Spannable
        }

        //var spanRes = Spannable.Factory.getInstance().newSpannable(result)
        setClickListenerOnHtmlImageGetter(result, this)
        richText.setText(result)
        richText.setMovementMethod(LinkMovementMethod.getInstance())


        //Picasso.get().load(imageUrl).placeholder(R.color.material_grey_600).into(promoImage)

        //zoomImage.setImageDrawable(promoImage.drawable)

        //promoImage.setOnClickListener { v -> Picasso.get().load(imageUrl).placeholder(R.color.material_grey_600).into(zoomImage); zoomLayout.visibility = View.VISIBLE }
    }


    fun setClickListenerOnHtmlImageGetter(html: Spannable, callback: ImageClickInterface) {
        val image_spans = html.getSpans(0, html.length, ImageSpan::class.java)

        for (span in image_spans) {

            val image_src = span.getSource()
            val start = html.getSpanStart(span)
            val end = html.getSpanEnd(span)

            val click_span = object : ClickableSpan() {

                override fun onClick(widget: View) {
                    callback.onClick()
                }
            }

            val click_spans = html.getSpans(start, end, ClickableSpan::class.java)

            if (click_spans.size != 0) {

                // remove all click spans
                for (c_span in click_spans) {
                    html.removeSpan(c_span)
                }
            }

            html.setSpan(click_span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        }
    }


}