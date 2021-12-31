package com.berisco.qrme

import android.graphics.Bitmap
import android.graphics.Point
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.WriterException
import kotlinx.android.synthetic.main.activity__q_r__code.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class Activity_QR_Code : AppCompatActivity() {

    var id = ""
    var isempty = ""
    var title = ""
    var property_1 = ""
    var property_2 = ""
    var property_3 = ""
    var property_4 = ""
    var property_5 = ""
    var property_6 = ""
    var property_7 = ""
    var property_8 = ""


    var bitmap: Bitmap? = null
    var qrgEncoder: QRGEncoder? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        id = (getIntent().getStringExtra("id")).toString()
        isempty = (getIntent().getStringExtra("isempty")).toString()
        title = (getIntent().getStringExtra("title")).toString()
        property_1 = (getIntent().getStringExtra("property_1")).toString()
        property_2 = (getIntent().getStringExtra("property_2")).toString()
        property_3 = (getIntent().getStringExtra("property_3")).toString()
        property_4 = (getIntent().getStringExtra("property_4")).toString()
        property_5 = (getIntent().getStringExtra("property_5")).toString()
        property_6 = (getIntent().getStringExtra("property_6")).toString()
        property_7 = (getIntent().getStringExtra("property_7")).toString()
        property_8 = (getIntent().getStringExtra("property_8")).toString()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__q_r__code)

        tv_code_name.setText(title)

        deferredResult()
//        generate_qr_code()
    }

    fun deferredResult() = GlobalScope.async {

        try {

            GlobalScope.async {

                runOnUiThread {
                    generate_qr_code()
                }

            }


        } catch (e: Exception) {

            println("printingxx vvvvv: Code: hu3221" + e.toString())
        } finally {
            //Turn off busy indicator.
        }

    }

    private fun generate_qr_code() {

        try {

            var sss = property_7
//        var sss = property_8


            println("Printingx sss $sss")

            if (sss.isEmpty()) {

                // if the edittext inputs are empty then execute
                // this method showing a toast message.
                Toast.makeText(
                    this,
                    "Enter some text to generate QR Code",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // below line is for getting
                // the windowmanager service.
                val manager = getSystemService(WINDOW_SERVICE) as WindowManager

                // initializing a variable for default display.
                val display = manager.defaultDisplay

                // creating a variable for point which
                // is to be displayed in QR Code.
                val point = Point()
                display.getSize(point)

                // getting width and
                // height of a point
                val width: Int = point.x
                val height: Int = point.y

                // generating dimension from width and height.
                var dimen = if (width < height) width else height
                dimen = dimen * 3 / 4

                // setting this dimensions inside our qr code0
                // encoder to generate our qr code.
                qrgEncoder = QRGEncoder(
                    sss,
                    null,
                    QRGContents.Type.TEXT,
                    dimen
                )
                try {
                    // getting our qrcode in the form of bitmap.
                    bitmap = qrgEncoder!!.encodeAsBitmap()
                    // the bitmap is set inside our image
                    // view using .setimagebitmap method.
                    qrCodeIV.setImageBitmap(bitmap)

                    //Toast.makeText(this, sss, Toast.LENGTH_SHORT).show()

                } catch (e: WriterException) {
                    // this method is called for
                    // exception handling.
                    Log.e("Printingx", e.toString())
                }
            }

        } catch (ex: Exception) {
            println("Printingx Exception IU994 $ex")
        }

    }


}