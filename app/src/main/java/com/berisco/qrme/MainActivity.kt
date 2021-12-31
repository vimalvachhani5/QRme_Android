package com.berisco.qrme

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.berisco.qrme.Adapter.Adapter_Accounts
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


var mAuth = FirebaseAuth.getInstance()
var FirebaseDatabase: FirebaseDatabase? =null
var myRef: DatabaseReference?=null
var user_id:String="null"

class MainActivity : AppCompatActivity() {

    var adapt_best_selling: Adapter_Accounts? = null

    var title : ArrayList<String> = ArrayList<String>()
    var id : ArrayList<String> = ArrayList<String>()
    var property_1: ArrayList<String> = ArrayList<String>()
    var property_2: ArrayList<String> = ArrayList<String>()
    var property_3: ArrayList<String> = ArrayList<String>()
    var property_4: ArrayList<String> = ArrayList<String>()
    var property_5: ArrayList<String> = ArrayList<String>()
    var property_6: ArrayList<String> = ArrayList<String>()
    var property_7: ArrayList<String> = ArrayList<String>()
    var property_8: ArrayList<String> = ArrayList<String>()
    var isempty: ArrayList<String> = ArrayList<String>()


    var Socail :Any? =null
//    var Crypto :Any? =null
    var Me :Any? =null
//    var Business :Any? =null


    var twitter :Any? =null
    var instgram :Any? =null
    var facebook :Any? =null
    var twitter_isEmpty :Any? =null
    var instgram_isEmpty :Any? =null
    var facebook_isEmpty :Any? =null

    var linkedin :Any? =null
    var linkedin_isEmpty :Any? =null
//    var discord :Any? =null
//    var discord_isEmpty :Any? =null
    var whatsapp :Any? =null
    var whatsapp_isEmpty :Any? =null
    var snapchat :Any? =null
    var snapchat_isEmpty :Any? =null


    var Crypto_btc :Any? =null
    var Crypto_eth :Any? =null
    var btc_isEmpty :Any? =null
    var eth_isEmpty :Any? =null
//    var Crypto_isEmpty :Any? =null


    var me_personalFirstName :Any? =null
    var me_personalPhone:Any? =null
    var me_personalWebsite :Any? =null
    var me_personalLastName :Any? =null
    var me_personalEmail :Any? =null
    var me_isEmpty :Any? =null


//    var business_businessFirstName :Any? =null
//    var business_businessPhone:Any? =null
//    var business_businessWebsite :Any? =null
//    var business_businessLastName :Any? =null
//    var business_businessEmail :Any? =null
//    var business_isEmpty :Any? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()


        FirebaseDatabase = com.google.firebase.database.FirebaseDatabase.getInstance()
        myRef= FirebaseDatabase!!.reference
        val currentFirebaseUser = FirebaseAuth.getInstance().currentUser
        user_id =(currentFirebaseUser!!.uid).toString()

        println("Printingx user_id  $user_id")




    }

    override fun onStart() {
        super.onStart()

        //  this.supportActionBar?.hide()
        initializeadapter()

//        floating_action_button.setOnClickListener {
//            startActivity(Intent(this, Activity_Add_Accounts::class.java))
//        }

        textButton_add.setOnClickListener {
            startActivity(Intent(this, Activity_Add_Accounts::class.java))
        }

        textButton_logout.setOnClickListener {
            try{
                AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener { // user is now signed out
                        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
                        startActivity(
                            Intent(
                                this,
                                Activity_Auth_start::class.java
                            )
                        )
                        finish()
                    }
            }
            catch (ex:Exception){
                println("Printingxx : Exception JUKH432   $ex")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
//        R.id.action_fav -> {
//            // do stuff
//
//            startActivity(Intent(this, Activity_Add_Accounts::class.java))
//
//            true
//        }
//        else -> super.onOptionsItemSelected(item)
//    }


    fun initializeadapter() {
        try {

            try {

                recyclerview_best_selling_explore.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )

                adapt_best_selling =
                    Adapter_Accounts(
                        id,
                        property_1,
                        property_2,
                        property_3,
                        property_4,
                        property_6,
                        property_7,
                        property_8,
                        property_5,
                        title,
                        isempty,

                        this
                    )
                recyclerview_best_selling_explore.adapter = adapt_best_selling


               // get_sample_data()
                getdatafromfirebase()


            } catch (ex: Exception) {
                // Toast.makeText(this,"Code: 22ds\n\n"+ex.localizedMessage.toString(), Toast.LENGTH_LONG).show()
                println("Printingxx vvvvv: " + "Code: 22ds\n\n" + ex.localizedMessage.toString())

            }

        } catch (e: Exception) {
            println("Printingxx vvvvv: " + "Code: 2ecs343\n\n" + e.localizedMessage.toString())
        }


    }


    fun get_sample_data()
    {
        var i:Int = 0
        while(i<30){

            title.add("Sample Text")
            id.add("Sample Text")
            property_1.add("This is a Sample Text of a video how video is shown on memester app.")
            property_2.add("Sample Text")
            property_3.add("Sample Text")

            property_4.add("Sample Text")
            property_6.add("Sample Text")
            property_7.add("Sample Text")
            isempty.add("Sample Text")
            property_8.add("Sample Text")
            property_5.add("Sample Text")


            i++


        }


        //activity!!.runOnUiThread(Runnable {

        adapt_best_selling!!.notifyDataSetChanged()
        //  progressDialog.stop_progress_dialog()


        //  })


    }


    fun getdatafromfirebase(){

        try{


            myRef?.child(user_id)!!.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {

                    println("Printingx onDataChange p0 == $p0 ")

                    title.clear()
                    id.clear()
                    property_1.clear()
                    property_2.clear()
                    property_3.clear()
                    property_4.clear()
                    property_5.clear()
                    property_6.clear()
                    property_7.clear()
                    property_8.clear()
                    isempty.clear()

                    if (p0.exists())
                    {
                        println("Printingx  (p0.exists()) ")

                        var xxx = p0.children.forEach { xx ->

                          //   Socail = xx.child("Socail").value
//                             Crypto = xx.child("Crypto").value
                             Me = xx.child("Me").value
//                             Business = xx.child("Business").value

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


//                            Crypto_btc = xx.child("Crypto").child("btc").value
//                             Crypto_eth = xx.child("Crypto").child("eth").value
//                             Crypto_isEmpty = xx.child("Crypto").child("isEmpty").value

                            Crypto_btc = xx.child("BTC").child("btc").value
                            btc_isEmpty = xx.child("BTC").child("isEmpty").value

                            Crypto_eth = xx.child("ETH").child("eth").value
                            eth_isEmpty = xx.child("ETH").child("isEmpty").value




                             me_personalFirstName = xx.child("Me").child("personalFirstName").value
                             me_personalPhone= xx.child("Me").child("personalPhone").value
                             me_personalWebsite = xx.child("Me").child("personalWebsite").value
                             me_personalLastName = xx.child("Me").child("personalLastName").value
                             me_personalEmail = xx.child("Me").child("personalEmail").value
                             me_isEmpty = xx.child("Me").child("isEmpty").value


//                             business_businessFirstName = xx.child("Business").child("businessFirstName").value
//                             business_businessPhone= xx.child("Business").child("businessPhone").value
//                             business_businessWebsite = xx.child("Business").child("businessWebsite").value
//                             business_businessLastName = xx.child("Business").child("businessLastName").value
//                             business_businessEmail = xx.child("Business").child("businessEmail").value
//                             business_isEmpty = xx.child("Business").child("isEmpty").value



//                            println("Printingx --------------------------------------------------")
                            println("Printingx xx == $xx ")
//                            println("Printingx Crypto == $Crypto ")
                            println("Printingx Socail == $Socail ")
                            println("Printingx Me == $Me ")
//                            println("Printingx Business == $Business ")
//                            println("Printingx --------------------------------------------------")

//                            println("Printingx facebook == $facebook ")
//                            println("Printingx me_personalLastName == $me_personalLastName ")
//                            println("Printingx business_businessLastName == $business_businessLastName ")

                            if (me_isEmpty==false){


                                title.add("Me")
                                id.add("1")
                                property_1.add(me_personalFirstName.toString())
                                property_2.add(me_personalLastName.toString())
                                property_3.add(me_personalPhone.toString())
                                property_4.add(me_personalWebsite.toString())
                                property_5.add(me_personalEmail.toString())
                                property_6.add("")

                                property_8.add(Me.toString())
                                isempty.add(me_isEmpty.toString())

                                var fn = me_personalFirstName.toString()
                                var ln = me_personalLastName.toString()
                                var pn = me_personalPhone.toString()
                                var web =me_personalWebsite.toString()
                                var email = me_personalEmail.toString()

                                var v_card_str="BEGIN:VCARD\n" +
                                        "VERSION:2.1\n" +
                                        "N:$ln;$fn;;\n" +
                                        "FN:$fn $ln\n" +
                                        //"ORG:Bubba Gump Shrimp Co.\n" +
                                       // "TITLE:Shrimp Man\n" +
                                       // "PHOTO;GIF:http://www.example.com/dir_photos/my_photo.gif\n" +
                                       // "TEL;WORK;VOICE:(111) 555-1212\n" +
                                        "TEL;CELL;VOICE:$pn\n" +
                                        //"ADR;WORK;PREF:;;100 Waters Edge;Baytown;LA;30314;United States of America\n" +
                                        //"LABEL;WORK;PREF;ENCODING#QUOTED-PRINTABLE;CHARSET#UTF-8:100 Waters Edge#0D#\n" +
                                        //" #0ABaytown\\, LA 30314#0D#0AUnited States of America\n" +
                                        //"ADR;HOME:;;42 Plantation St.;Baytown;LA;30314;United States of America\n" +
                                        //"LABEL;HOME;ENCODING#QUOTED-PRINTABLE;CHARSET#UTF-8:42 Plantation St.#0D#0A#\n" +
                                        //" Baytown, LA 30314#0D#0AUnited States of America\n" +
                                        "EMAIL:$email\n" +
                                        "URL:$web\n" +
//                                        "URL;type=website:$web\n" +


                                        "REV:20080424T195243Z\n" +
                                        "END:VCARD"


                                    property_7.add(v_card_str.toString())
//                                    property_7.add(Me.toString())

                            }

//                            if (business_isEmpty==false){
//                                title.add("Business")
//                                id.add("2")
//                                property_1.add(business_businessFirstName.toString())
//                                property_2.add(business_businessLastName.toString())
//                                property_3.add(business_businessPhone.toString())
//                                property_4.add(business_businessWebsite.toString())
//                                property_5.add(business_businessEmail.toString())
//                                property_6.add("")
//                                property_7.add("")
//                                property_8.add(Business.toString())
//                                isempty.add(business_isEmpty.toString())
//                            }

                            if (facebook_isEmpty==false){
                                title.add("Facebook")
                                id.add("3")
                                property_1.add(facebook.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(facebook.toString())
                                property_8.add("Facebook")
                                isempty.add(facebook_isEmpty.toString())
                            }

                            if (instgram_isEmpty==false){
                                title.add("Instagram")
                                id.add("4")
                                property_1.add(instgram.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(instgram.toString())
                                property_8.add("Instagram")
                                isempty.add(instgram_isEmpty.toString())
                            }

                            if (twitter_isEmpty==false){
                                title.add("Twitter")
                                id.add("5")
                                property_1.add(twitter.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(twitter.toString())
                                property_8.add("Twitter")
                                isempty.add(twitter_isEmpty.toString())
                            }
                            if (linkedin_isEmpty==false){
                                title.add("Linkedln")
                                id.add("6")
                                property_1.add(linkedin.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(linkedin.toString())
                                property_8.add("Linkedln")
                                isempty.add(linkedin_isEmpty.toString())
                            }

//                            if (discord_isEmpty==false){
//                                title.add("Discord")
//                                id.add("7")
//                                property_1.add(discord.toString())
//                                property_2.add("")
//                                property_3.add("")
//                                property_4.add("")
//                                property_5.add("")
//                                property_6.add("")
//                                property_7.add("")
//                                property_8.add("Discord")
//                                isempty.add(discord_isEmpty.toString())
//                            }

                            if (whatsapp_isEmpty==false){
                                title.add("Whatsapp")
                                id.add("8")
                                property_1.add(whatsapp.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(whatsapp.toString())
                                property_8.add("Whatsapp")
                                isempty.add(whatsapp_isEmpty.toString())
                            }

                            if (snapchat_isEmpty==false){
                                title.add("Snapchat")
                                id.add("9")
                                property_1.add(snapchat.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(snapchat.toString())
                                property_8.add("Snapchat")
                                isempty.add(snapchat_isEmpty.toString())
                            }



                            if (btc_isEmpty==false){
                                title.add("BTC")
                                id.add("10")
                                property_1.add(Crypto_btc.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")

                                property_8.add(Crypto_btc.toString())
                                isempty.add(btc_isEmpty.toString())

                                var btc = Crypto_btc.toString()
                                var s = "$btc"
                                property_7.add(s)
                            }

                            if (eth_isEmpty==false){
                                title.add("ETH")
                                id.add("11")
                                property_1.add(Crypto_eth.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")

                                property_8.add(Crypto_eth.toString())
                                isempty.add(eth_isEmpty.toString())

                                var eth = Crypto_eth.toString()
                                var s = "$eth"
                                property_7.add(s)
                            }

// --------------------------- add at bottom
                            if (me_isEmpty==true){
                                title.add("Me")
                                id.add("1")
                                property_1.add(me_personalFirstName.toString())
                                property_2.add(me_personalLastName.toString())
                                property_3.add(me_personalPhone.toString())
                                property_4.add(me_personalWebsite.toString())
                                property_5.add(me_personalEmail.toString())
                                property_6.add("")
                                property_7.add("")
                                property_8.add(Me.toString())
                                isempty.add(me_isEmpty.toString())
                            }

//                            if (business_isEmpty==true){
//                                title.add("Business")
//                                id.add("2")
//                                property_1.add(business_businessFirstName.toString())
//                                property_2.add(business_businessLastName.toString())
//                                property_3.add(business_businessPhone.toString())
//                                property_4.add(business_businessWebsite.toString())
//                                property_5.add(business_businessEmail.toString())
//                                property_6.add("")
//                                property_7.add("")
//                                property_8.add(Business.toString())
//                                isempty.add(business_isEmpty.toString())
//                            }

                            if (facebook_isEmpty==true){
                                title.add("Facebook")
                                id.add("3")
                                property_1.add(facebook.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Facebook")
                                isempty.add(facebook_isEmpty.toString())
                            }

                            if (instgram_isEmpty==true){
                                title.add("Instagram")
                                id.add("4")
                                property_1.add(instgram.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Instagram")
                                isempty.add(instgram_isEmpty.toString())
                            }

                            if (twitter_isEmpty==true){
                                title.add("Twitter")
                                id.add("5")
                                property_1.add(twitter.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Twitter")
                                isempty.add(twitter_isEmpty.toString())
                            }
                            if (linkedin_isEmpty==true){
                                title.add("Linkedln")
                                id.add("6")
                                property_1.add(linkedin.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Linkedln")
                                isempty.add(linkedin_isEmpty.toString())
                            }
//                            if (discord_isEmpty==true){
//                                title.add("Discord")
//                                id.add("7")
//                                property_1.add(discord.toString())
//                                property_2.add("")
//                                property_3.add("")
//                                property_4.add("")
//                                property_5.add("")
//                                property_6.add("")
//                                property_7.add("")
//                                property_8.add("Discord")
//                                isempty.add(discord_isEmpty.toString())
//                            }
                            if (whatsapp_isEmpty==true){
                                title.add("Whatsapp")
                                id.add("8")
                                property_1.add(whatsapp.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Whatsapp")
                                isempty.add(whatsapp_isEmpty.toString())
                            }

                            if (snapchat_isEmpty==true){
                                title.add("Snapchat")
                                id.add("9")
                                property_1.add(snapchat.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add("")
                                property_8.add("Snapchat")
                                isempty.add(snapchat_isEmpty.toString())
                            }


                            if (btc_isEmpty==true){
                                title.add("BTC")
                                id.add("10")
                                property_1.add(Crypto_btc.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(Crypto_btc.toString())
                                property_8.add(Crypto_btc.toString())
                                isempty.add(btc_isEmpty.toString())
                            }

                            if (eth_isEmpty==true){
                                title.add("ETH")
                                id.add("11")
                                property_1.add(Crypto_eth.toString())
                                property_2.add("")
                                property_3.add("")
                                property_4.add("")
                                property_5.add("")
                                property_6.add("")
                                property_7.add(Crypto_eth.toString())
                                property_8.add(Crypto_eth.toString())
                                isempty.add(eth_isEmpty.toString())
                            }

                            adapt_best_selling!!.notifyDataSetChanged()

                        }


                    }
                  //  /*
                    else
                    {
                        println("Printingx ELSE (p0.exists()) ")

// ************************** value is null =======================
                        if(p0.value == null ){
                            println("Printingx p0.value == null  ")

                            title.add("Me")
                            id.add("1")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Me")
                            isempty.add("true")


                            title.add("Facebook")
                            id.add("3")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Facebook")
                            isempty.add("true")


                            title.add("Instagram")
                            id.add("4")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Instagram")
                            isempty.add("true")

                            title.add("Twitter")
                            id.add("5")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Twitter")
                            isempty.add("true")

                            title.add("Linkedln")
                            id.add("6")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Linkedln")
                            isempty.add("true")



                            title.add("Whatsapp")
                            id.add("8")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Whatsapp")
                            isempty.add("true")

                            title.add("Snapchat")
                            id.add("9")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("Snapchat")
                            isempty.add("true")

                            title.add("BTC")
                            id.add("10")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("BTC")
                            isempty.add("true")

                            title.add("ETH")
                            id.add("11")
                            property_1.add("")
                            property_2.add("")
                            property_3.add("")
                            property_4.add("")
                            property_5.add("")
                            property_6.add("")
                            property_7.add("")
                            property_8.add("ETH")
                            isempty.add("true")


//                            title.add("Business")
//                            id.add("2")
//                            property_1.add("")
//                            property_2.add("")
//                            property_3.add("")
//                            property_4.add("")
//                            property_5.add("")
//                            property_6.add("")
//                            property_7.add("")
//                            property_8.add("Business")
//                            isempty.add("true")

//                            title.add("Social")
//                            id.add("3")
//                            property_1.add("")
//                            property_2.add("")
//                            property_3.add("")
//                            property_4.add("")
//                            property_5.add("")
//                            property_6.add("")
//                            property_7.add("")
//                            property_8.add("Socail")
//                            isempty.add("true")

//                            title.add("Crypto")
//                            id.add("4")
//                            property_1.add("")
//                            property_2.add("")
//                            property_3.add("")
//                            property_4.add("")
//                            property_5.add("")
//                            property_6.add("")
//                            property_7.add("")
//                            property_8.add("Crypto")
//                            isempty.add("true")

                        }
                        else{println("Printingx ELSE p0.value ")}
// ************************** value is null =======================
                        adapt_best_selling!!.notifyDataSetChanged()

                    }
                  //  */


                }

                override fun onCancelled(p0: DatabaseError) {
                    println("Printingx onCancelled p0 == $p0 ")
                }

            })

        }
        catch (ex: Exception){
            println("Printingx Exception IUUENN3883 $ex")
        }


    }





}