package com.berisco.qrme.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.berisco.qrme.Activity_QR_Code
import com.berisco.qrme.R
import kotlinx.android.synthetic.main.customview_account.view.*


import org.json.JSONObject
import java.io.IOException

//import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class Adapter_Accounts(
    private val id: ArrayList<String>,
    private val property_1: ArrayList<String>,
    private val property_2: ArrayList<String>,
    private val property_3: ArrayList<String>,
    private val property_4: ArrayList<String>,
    private val  property_6: ArrayList<String>,
    private val property_7: ArrayList<String>,
    private val  property_8: ArrayList<String>,
    private val property_5: ArrayList<String>,
    private val title: ArrayList<String>,
    private val isempty: ArrayList<String>,


    private val ctx: Context// , val y : String ,
        //	private val name:ArrayList<String>
) : RecyclerView.Adapter<CustomViewHolder_All_Likes>() {
    override fun getItemCount(): Int {
        return title.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder_All_Likes {

        val layoutInflater = LayoutInflater.from(p0?.context)
        val customview = layoutInflater.inflate(R.layout.customview_account, p0, false)
        return CustomViewHolder_All_Likes(customview)
    }


    override fun onBindViewHolder(holder: CustomViewHolder_All_Likes, position: Int) {

        try {
            println("printingxx  (title[position]) " + (title[position]))
            holder.view.tv_acc_name.text = (title[position]).toString()


            when {
                ((title[position]).toString()) == "BTC" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.btc_1)

                }
                ((title[position]).toString()) == "ETH" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.eth)

                }
                ((title[position]).toString()) == "Facebook" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.facebook)
                }
                ((title[position]).toString()) == "Instagram" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.insta)
                }
                ((title[position]).toString()) == "Twitter" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.twitter)
                }
                ((title[position]).toString()) == "Linkedln" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.linkedin)
                }
                ((title[position]).toString()) == "Discord" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.discord)
                }
                ((title[position]).toString()) == "Whatsapp" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.whatapp)
                }
                ((title[position]).toString()) == "Snapchat" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.snapchat)
                }
                ((title[position]).toString()) == "Business" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.business_logo)

                }
                ((title[position]).toString()) == "Me" -> {
                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.user_personal)

                }
            }


            if( ((isempty[position]).toString()).equals("false") ){
                holder.view.tv_acc_status.text = ("Active").toString()


                holder.view.cp_cardview.setOnClickListener{

                    val intent = Intent(ctx, Activity_QR_Code::class.java)
                    intent.putExtra("id", id[position].toString())
                    intent.putExtra("isempty", isempty[position].toString())
                    intent.putExtra("title", title[position].toString())
                    intent.putExtra("property_1", property_1[position].toString())
                    intent.putExtra("property_2", property_2[position].toString())
                    intent.putExtra("property_3", property_3[position].toString())
                    intent.putExtra("property_4", property_4[position].toString())
                    intent.putExtra("property_5", property_5[position].toString())
                    intent.putExtra("property_6", property_6[position].toString())
                    intent.putExtra("property_7", property_7[position].toString())
                    intent.putExtra("property_8", property_8[position].toString())
                    ctx.startActivity(intent)

                }

//                if(((title[position]).toString()).equals("Crypto")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.crypto_logo)
//
//                }
//                if(((title[position]).toString()).equals("BTC")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.btc)
//
//                }
//                else if(((title[position]).toString()).equals("ETH")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.eth)
//
//                }
//
//                else if(((title[position]).toString()).equals("Facebook")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.facebook)
//                }
//                else if(((title[position]).toString()).equals("Instagram")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.insta)
//                }
//                else if(((title[position]).toString()).equals("Twitter")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.twitter)
//                }
//                else if(((title[position]).toString()).equals("Linkedln")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.linkedin)
//                }
//                else if(((title[position]).toString()).equals("Discord")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.discord)
//                }
//                else if(((title[position]).toString()).equals("Whatsapp")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.whatapp)
//                }
//                else if(((title[position]).toString()).equals("Snapchat")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.snapchat)
//                }
//
//
//                else if(((title[position]).toString()).equals("Business")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.business_logo)
//
//                }
//                else if(((title[position]).toString()).equals("Me")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.user_personal)
//
//                }

            }
            else
            {
                holder.view.tv_acc_status.text = ("Inactive").toString()

                holder.view.cp_view.setBackgroundColor(ContextCompat.getColor(ctx, R.color.disable_grey))
                holder.view.imageview_user_post_home_customview.setColorFilter(ContextCompat.getColor(ctx, R.color.disable_grey), android.graphics.PorterDuff.Mode.MULTIPLY);

//                if(((title[position]).toString()).equals("Crypto")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.crypto_logo)
//
//                }
//                 if(((title[position]).toString()).equals("BTC")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.btc)
//
//                }
//                else if(((title[position]).toString()).equals("ETH")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.eth)
//
//                }
//                else if(((title[position]).toString()).equals("Facebook")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.facebook)
//                }
//                else if(((title[position]).toString()).equals("Instagram")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.insta)
//                }
//                else if(((title[position]).toString()).equals("Twitter")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.twitter)
//                }
//                else if(((title[position]).toString()).equals("Linkedln")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.linkedin)
//                }
//                else if(((title[position]).toString()).equals("Discord")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.discord)
//                }
//                else if(((title[position]).toString()).equals("Whatsapp")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.whatapp)
//                }
//                else if(((title[position]).toString()).equals("Snapchat")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.snapchat)
//                }
//                else if(((title[position]).toString()).equals("Business")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.business_logo)
//
//                }
//                else if(((title[position]).toString()).equals("Me")){
//                    holder.view.imageview_user_post_home_customview.setImageResource(R.drawable.user_personal)
//
//                }

            }


        //            Picasso.get().load(All_Likes_userImage[position]).into(holder.view.iv_profile_all_like)






        } catch (ex: Exception) {
            println("printingxx Exception : NJH33 Adapter " + ex.toString())
        }

    }

//
//    fun change_date_format(date: String):String
//    {
//        try
//        {
//            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//            val formatter = SimpleDateFormat("MMM dd, yyyy hh:mm aa")
//
//
//            parser.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//            val output: String = formatter.format(parser.parse(date))
//
//            //   println("printingxx Converted DATE " + output.toString())
//
//            return output
//        }
//        catch (ex: Exception)
//        {
//            println("printingxx Exception : HU45HI From Adapter Post Home " + ex.toString())
//            return date
//        }
//    }



}

class CustomViewHolder_All_Likes(val view: View) : RecyclerView.ViewHolder(view) {

}