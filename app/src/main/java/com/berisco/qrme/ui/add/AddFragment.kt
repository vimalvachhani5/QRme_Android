package com.berisco.qrme.ui.add

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.berisco.qrme.FirebaseDatabase
import com.berisco.qrme.R
import com.berisco.qrme.myRef
import com.berisco.qrme.user_id
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {


    var Socail: Any? = null
    var Crypto: Any? = null
    var Me: Any? = null
//    var Business :Any? =null


    var twitter: Any? = null
    var instgram: Any? = null
    var facebook: Any? = null
    var twitter_isEmpty: Any? = null
    var instgram_isEmpty: Any? = null
    var facebook_isEmpty: Any? = null

    var linkedin: Any? = null
    var linkedin_isEmpty: Any? = null

    //    var discord :Any? =null
//    var discord_isEmpty :Any? =null
    var whatsapp: Any? = null
    var whatsapp_isEmpty: Any? = null
    var snapchat: Any? = null
    var snapchat_isEmpty: Any? = null


    var Crypto_btc: Any? = null
    var Crypto_eth: Any? = null
    var eth_isEmpty: Any? = null
    var btc_isEmpty: Any? = null
//    var Crypto_isEmpty :Any? =null


    var me_personalFirstName: Any? = null
    var me_personalPhone: Any? = null
    var me_personalWebsite: Any? = null
    var me_personalLastName: Any? = null
    var me_personalEmail: Any? = null
    var me_isEmpty: Any? = null


//    var business_businessFirstName :Any? =null
//    var business_businessPhone:Any? =null
//    var business_businessWebsite :Any? =null
//    var business_businessLastName :Any? =null
//    var business_businessEmail :Any? =null
//    var business_isEmpty :Any? =null

    private lateinit var addViewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addViewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add, container, false)

        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {

            getdatafromfirebase()

            et_personal_website.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_personal_website.getText().toString())
                    if (x) {

                        follow_link_et_personal_website.visibility = View.VISIBLE

                        if (et_personal_website.text.isEmpty()) {
                            follow_link_et_personal_website.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_personal_website.text.isNotEmpty()) {
//                        et_personal_website.setError("Invalid Url")
                        }
                        follow_link_et_personal_website.visibility = View.INVISIBLE
                    }

                }

                override fun afterTextChanged(s: Editable) {}
            })

            //  /*
            et_facebook.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_facebook.getText().toString())
                    if (x) {

                        follow_link_et_facebook.visibility = View.VISIBLE

                        if (et_facebook.text.isEmpty()) {
                            follow_link_et_facebook.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_facebook.text.isNotEmpty()) {
//                        et_facebook.setError("Invalid Url")
                        }
                        follow_link_et_facebook.visibility = View.INVISIBLE
                    }

                }

                override fun afterTextChanged(s: Editable) {}
            })
            // */

            et_twitter.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_twitter.getText().toString())
                    if (x) {

                        follow_link_et_twitter.visibility = View.VISIBLE

                        if (et_twitter.text.isEmpty()) {
                            follow_link_et_twitter.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_twitter.text.isNotEmpty()) {
//                        et_twitter.setError("Invalid Url")
                        }
                        follow_link_et_twitter.visibility = View.INVISIBLE
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })

            et_instagram.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_instagram.getText().toString())
                    if (x) {

                        follow_link_et_instagram.visibility = View.VISIBLE

                        if (et_instagram.text.isEmpty()) {
                            follow_link_et_instagram.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_instagram.text.isNotEmpty()) {
//                        et_instagram.setError("Invalid Url")
                        }
                        follow_link_et_instagram.visibility = View.INVISIBLE
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })

//        et_discord.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//            // whenever text size changes it will check
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//
//                var x = urlValidate(et_discord.getText().toString())
//                if (x) {
//
//                    follow_link_et_discord.visibility = View.VISIBLE
//
//                    if (et_discord.text.isEmpty()) {
//                        follow_link_et_discord.visibility = View.INVISIBLE
//                    }
//
//                } else {
//                    // otherwise show error of invalid url
//                    if (et_discord.text.isNotEmpty()) {
////                        et_discord.setError("Invalid Url")
//                    }
//                    follow_link_et_discord.visibility = View.INVISIBLE
//                }
//            }
//
//            override fun afterTextChanged(s: Editable) {}
//        })

            et_linkedin.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_linkedin.getText().toString())
                    if (x) {

                        follow_link_et_linkedin.visibility = View.VISIBLE

                        if (et_linkedin.text.isEmpty()) {
                            follow_link_et_linkedin.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_linkedin.text.isNotEmpty()) {
//                        et_linkedin.setError("Invalid Url")
                        }
                        follow_link_et_linkedin.visibility = View.INVISIBLE
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })

            et_whatsapp.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_whatsapp.getText().toString())
                    if (x) {

                        follow_link_et_whatsapp.visibility = View.VISIBLE

                        if (et_whatsapp.text.isEmpty()) {
                            follow_link_et_whatsapp.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_whatsapp.text.isNotEmpty()) {
//                        et_whatsapp.setError("Invalid Url")
                        }
                        follow_link_et_whatsapp.visibility = View.INVISIBLE
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })

            et_snapchat.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                // whenever text size changes it will check
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    var x = urlValidate(et_snapchat.getText().toString())
                    if (x) {

                        follow_link_et_snapchat.visibility = View.VISIBLE

                        if (et_snapchat.text.isEmpty()) {
                            follow_link_et_snapchat.visibility = View.INVISIBLE
                        }

                    } else {
                        // otherwise show error of invalid url
                        if (et_snapchat.text.isNotEmpty()) {
//                        et_snapchat.setError("Invalid Url")
                        }
                        follow_link_et_snapchat.visibility = View.INVISIBLE
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })


            follow_link_et_personal_website.setOnClickListener {
                open_link((et_personal_website.text).toString())
            }

            follow_link_et_facebook.setOnClickListener {
                open_link((et_facebook.text).toString())
            }

            follow_link_et_twitter.setOnClickListener {
                open_link((et_twitter.text).toString())
            }

            follow_link_et_instagram.setOnClickListener {
                open_link((et_instagram.text).toString())
            }

//        follow_link_et_discord.setOnClickListener {
//            open_link((et_discord.text).toString())
//        }

            follow_link_et_linkedin.setOnClickListener {
                open_link((et_linkedin.text).toString())
            }

            follow_link_et_whatsapp.setOnClickListener {
                open_link((et_whatsapp.text).toString())
            }

            follow_link_et_snapchat.setOnClickListener {
                open_link((et_snapchat.text).toString())
            }


        } catch (ex: Exception) {
            println("Printingxx : Exception HIUU923   $ex")
        }

    }


    override fun onStart() {
        super.onStart()

        try {


//        getdatafromfirebase()



            btn_save_data.setOnClickListener {

                if (et_first_name.text.isNotEmpty() && et_last_name.text.isNotEmpty()) {

//            if (et_business_first_name.text.isNotEmpty() && et_business_last_name.text.isNotEmpty())
//            {
//                var x_1 = urlValidate(et_facebook.getText().toString())
//                var x_2 = urlValidate(et_instagram.getText().toString())
//                var x_3 = urlValidate(et_twitter.getText().toString())
////                var x_4= urlValidate(et_discord.getText().toString())
//                var x_5 = urlValidate(et_linkedin.getText().toString())
//                var x_6 = urlValidate(et_snapchat.getText().toString())
//                var x_7 = urlValidate(et_whatsapp.getText().toString())

//                if(x_1 && x_2 && x_3  && x_5 && x_6 && x_7 ){
                    save_data()
//                }
//                else
//                {
//                    Toast.makeText(
//                        this,
//                        "Invalid url",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }

//            }
//            else
//            {
//                Toast.makeText(
//                    this,
//                    "Missing Business First Name and Last Name",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Missing Person First Name and Last Name",
                        Toast.LENGTH_SHORT
                    ).show()
                }


//            save_data()
            }

        } catch (ex: Exception) {
            println("Printingxx : Exception VTUW9843   $ex")
        }

    }


    fun save_data() {
        try {

            var personalEmail = et_personal_email.text
            var personalFirstName = et_first_name.text
            var personalLastName = et_last_name.text
            var personalPhone = et_personal_phone.text
            var personalWebsite = et_personal_website.text


//            var businessEmail = et_business_email.text
//            var businessFirstName = et_business_first_name.text
//            var businessLastName = et_business_last_name.text
//            var businessPhone = et_business_phone.text
//            var businessWebsite = et_business_website.text


            var btc = et_btc.text
            var eth = et_eth.text


//            var facebook = et_facebook.text
//            var instgram = et_instagram.text
//            var twitter = et_twitter.text


//            var Business_check=true
            var Crypto_check = true
            var Me_check = true
//            var Socail_check=true

            Me_check = !(et_first_name.text.isNotEmpty() && et_last_name.text.isNotEmpty())
//            Business_check = !(et_business_first_name.text.isNotEmpty() && et_business_last_name.text.isNotEmpty())

//            Socail_check = !(et_facebook.text.isNotEmpty() || et_instagram.text.isNotEmpty() || et_twitter.text.isNotEmpty())
            Crypto_check = !(et_btc.text.isNotEmpty() || et_eth.text.isNotEmpty())

            // ------------------------------------------------------------------------


            println("Printingx user_id  $user_id")
            var ref = FirebaseDatabase!!.getReference(user_id).child("data")

            ref.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {


                    //  println("Printingx DataSnapshot = $p0")


//                    ref.child("Business").child("businessEmail").setValue("$businessEmail")
//                    ref.child("Business").child("businessFirstName").setValue("$businessFirstName")
//                    ref.child("Business").child("businessLastName").setValue("$businessLastName")
//                    ref.child("Business").child("businessPhone").setValue("$businessPhone")
//                    ref.child("Business").child("businessWebsite").setValue("$businessWebsite")
//                    ref.child("Business").child("isEmpty").setValue(Business_check)


                    if (et_btc.text.isNotEmpty()) {
                        ref.child("BTC").child("btc")
                            .setValue((et_btc.text).toString())
                        ref.child("BTC").child("isEmpty").setValue(false)

                    } else {
                        ref.child("BTC").child("btc").setValue((et_btc.text).toString())
                        ref.child("BTC").child("isEmpty").setValue(true)
                    }

                    if (et_eth.text.isNotEmpty()) {
                        ref.child("ETH").child("eth").setValue((et_eth.text).toString())
                        ref.child("ETH").child("isEmpty").setValue(false)

                    } else {
                        ref.child("ETH").child("eth")
                            .setValue((et_eth.text).toString())
                        ref.child("ETH").child("isEmpty").setValue(true)
                    }

//                    ref.child("Crypto").child("btc").setValue("$btc")
//                    ref.child("Crypto").child("eth").setValue("$eth")
//                    ref.child("Crypto").child("isEmpty").setValue(Crypto_check)
//


                    ref.child("Me").child("personalEmail").setValue("$personalEmail")
                    ref.child("Me").child("personalFirstName").setValue("$personalFirstName")
                    ref.child("Me").child("personalLastName").setValue("$personalLastName")
                    ref.child("Me").child("personalPhone").setValue("$personalPhone")
                    ref.child("Me").child("personalWebsite").setValue("$personalWebsite")
                    ref.child("Me").child("isEmpty").setValue(Me_check)


//                    ref.child("Socail").child("facebook").setValue("$facebook")
//                    ref.child("Socail").child("instgram").setValue("$instgram")
//                    ref.child("Socail").child("twitter").setValue("$twitter")
//                    ref.child("Socail").child("isEmpty").setValue(Socail_check)


                    //  et_snapchat ===============================
                    if (et_snapchat.text.isNotEmpty()) {
                        ref.child("Snapchat").child("snapchat")
                            .setValue((et_snapchat.text).toString())
                        ref.child("Snapchat").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Snapchat").child("snapchat")
                            .setValue((et_snapchat.text).toString())
                        ref.child("Snapchat").child("isEmpty").setValue(true)
                    }

                    //    et_whatsapp ===============================
                    if (et_whatsapp.text.isNotEmpty()) {
                        ref.child("Whatsapp").child("whatsapp")
                            .setValue((et_whatsapp.text).toString())
                        ref.child("Whatsapp").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Whatsapp").child("whatsapp")
                            .setValue((et_whatsapp.text).toString())
                        ref.child("Whatsapp").child("isEmpty").setValue(true)
                    }

                    //     et_discord ===============================
//                    if (et_discord.text.isNotEmpty()) {
//                        ref.child("Discord").child("discord").setValue((et_discord.text).toString())
//                        ref.child("Discord").child("isEmpty").setValue(false)
//
//                    } else {
//                        ref.child("Discord").child("discord").setValue((et_discord.text).toString())
//                        ref.child("Discord").child("isEmpty").setValue(true)
//                    }

                    //        et_linkedin ===============================
                    if (et_linkedin.text.isNotEmpty()) {
                        ref.child("Linkedln").child("linkedln")
                            .setValue((et_linkedin.text).toString())
                        ref.child("Linkedln").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Linkedln").child("linkedln")
                            .setValue((et_linkedin.text).toString())
                        ref.child("Linkedln").child("isEmpty").setValue(true)
                    }


                    //            var facebook = et_facebook.text
                    if (et_facebook.text.isNotEmpty()) {
                        ref.child("Facebook").child("facebook")
                            .setValue((et_facebook.text).toString())
                        ref.child("Facebook").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Facebook").child("facebook")
                            .setValue((et_facebook.text).toString())
                        ref.child("Facebook").child("isEmpty").setValue(true)
                    }


//            var instgram = et_instagram.text

                    if (et_instagram.text.isNotEmpty()) {
                        ref.child("Instagram").child("instagram")
                            .setValue((et_instagram.text).toString())
                        ref.child("Instagram").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Instagram").child("instagram")
                            .setValue((et_instagram.text).toString())
                        ref.child("Instagram").child("isEmpty").setValue(true)
                    }


//            var twitter = et_twitter.text
                    if (et_twitter.text.isNotEmpty()) {
                        ref.child("Twitter").child("twitter").setValue((et_twitter.text).toString())
                        ref.child("Twitter").child("isEmpty").setValue(false)

                    } else {
                        ref.child("Twitter").child("twitter").setValue((et_twitter.text).toString())
                        ref.child("Twitter").child("isEmpty").setValue(true)
                    }



                    Toast.makeText(requireContext(), "Data Save Successfully", Toast.LENGTH_LONG)
                        .show()

                }

                override fun onCancelled(p0: DatabaseError) {

                    println("Printingx onCancelled  $p0")


                    // Toast.makeText(requireContext(), "onCancelled", Toast.LENGTH_LONG).show()
                }

            })


        } catch (ex: Exception) {
            println("Printingx Exception UIEU9393 $ex")
            println("Printingx Exception  --  " + ex.toString())

            Toast.makeText(requireContext(), ex.toString(), Toast.LENGTH_LONG).show()

        }
    }


    fun getdatafromfirebase() {

        try {


            myRef?.child(user_id)!!.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {


                    if (p0.exists()) {
                        var xxx = p0.children.forEach { xx ->

                            Socail = xx.child("Socail").value
                            Crypto = xx.child("Crypto").value
                            Me = xx.child("Me").value
//                            Business = xx.child("Business").value

                            twitter = xx.child("Twitter").child("twitter").value
                            twitter_isEmpty = xx.child("Twitter").child("isEmpty").value

                            instgram = xx.child("Instagram").child("instagram").value
                            instgram_isEmpty = xx.child("Instagram").child("isEmpty").value

                            facebook = xx.child("Facebook").child("facebook").value
                            facebook_isEmpty = xx.child("Facebook").child("isEmpty").value


// ===================================================================
                            linkedin = xx.child("Linkedln").child("linkedln").value
                            linkedin_isEmpty = xx.child("Linkedln").child("isEmpty").value

//                            discord = xx.child("Discord").child("discord").value
//                            discord_isEmpty = xx.child("Discord").child("isEmpty").value

                            whatsapp = xx.child("Whatsapp").child("whatsapp").value
                            whatsapp_isEmpty = xx.child("Whatsapp").child("isEmpty").value

                            snapchat = xx.child("Snapchat").child("snapchat").value
                            snapchat_isEmpty = xx.child("Snapchat").child("isEmpty").value
// ===================================================================


                            Crypto_btc = xx.child("BTC").child("btc").value
                            btc_isEmpty = xx.child("BTC").child("isEmpty").value

                            Crypto_eth = xx.child("ETH").child("eth").value
                            eth_isEmpty = xx.child("ETH").child("isEmpty").value
//                            Crypto_isEmpty = xx.child("Crypto").child("isEmpty").value


                            me_personalFirstName = xx.child("Me").child("personalFirstName").value
                            me_personalPhone = xx.child("Me").child("personalPhone").value
                            me_personalWebsite = xx.child("Me").child("personalWebsite").value
                            me_personalLastName = xx.child("Me").child("personalLastName").value
                            me_personalEmail = xx.child("Me").child("personalEmail").value
                            me_isEmpty = xx.child("Me").child("isEmpty").value


//                            business_businessFirstName =
//                                xx.child("Business").child("businessFirstName").value
//                            business_businessPhone =
//                                xx.child("Business").child("businessPhone").value
//                            business_businessWebsite =
//                                xx.child("Business").child("businessWebsite").value
//                            business_businessLastName =
//                                xx.child("Business").child("businessLastName").value
//                            business_businessEmail =
//                                xx.child("Business").child("businessEmail").value
//                            business_isEmpty = xx.child("Business").child("isEmpty").value


//                            println("Printingx --------------------------------------------------")
//                            println("Printingx xx == $xx ")
//                            println("Printingx Crypto == $Crypto ")
//                            println("Printingx Socail == $Socail ")
//                            println("Printingx Me == $Me ")
//                            println("Printingx Business == $Business ")
//                            println("Printingx --------------------------------------------------")

                            println("Printingx facebook == $facebook ")
                            println("Printingx me_personalLastName == $me_personalLastName ")
//                            println("Printingx business_businessLastName == $business_businessLastName ")

                            et_first_name.setText(me_personalFirstName.toString())
                            et_last_name.setText(me_personalLastName.toString())
                            et_personal_email.setText(me_personalEmail.toString())
                            et_personal_phone.setText(me_personalPhone.toString())
                            et_personal_website.setText(me_personalWebsite.toString())


//                            et_business_email.setText(business_businessEmail.toString())
//                            et_business_first_name.setText(business_businessFirstName.toString())
//                            et_business_phone.setText(business_businessPhone.toString())
//                            et_business_website.setText(business_businessWebsite.toString())
//                            et_business_last_name.setText(business_businessLastName.toString())

                            et_facebook.setText(facebook.toString())
                            et_instagram.setText(instgram.toString())
                            et_twitter.setText(twitter.toString())

//                            et_discord.setText(discord.toString())
                            et_snapchat.setText(snapchat.toString())
                            et_linkedin.setText(linkedin.toString())
                            et_whatsapp.setText(whatsapp.toString())


                            et_btc.setText(Crypto_btc.toString())
                            et_eth.setText(Crypto_eth.toString())


                        }


                    }


                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

        } catch (ex: Exception) {
            println("Printingx Exception IUUENN3883 $ex")
        }


    }


    var WebUrl =
        "^((ftp|http|https):\\/\\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-]+(\\.[a-zA-Z]+)+((\\/)[\\w#]+)*(\\/\\w+\\?[a-zA-Z0-9_]+=\\w+(&[a-zA-Z0-9_]+=\\w+)*)?$"

    private fun urlValidate(potentialUrl: String): Boolean {
        try {
            var website: String =
                (potentialUrl.trim()).toLowerCase() //txtWebsite.getText().toString().trim()
            if (website.trim { it <= ' ' }.isNotEmpty()) {
                if (!website.matches(WebUrl.toRegex())) {
                    //validation msg
                    return false
                }
            }
            return true
        }
        catch (ex:Exception){
            println("Printingxx : Exception UGHU93   $ex")
            return false
        }



    }


    fun open_link(s: String) {
        try {

            var url = s

            if (!url.startsWith("http://") && !url.startsWith("https://"))
                url = "http://" + url

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        } catch (ex: Exception) {
            println("Printingxx Exception KLKJ79875 : " + ex.toString())
        }
    }


}