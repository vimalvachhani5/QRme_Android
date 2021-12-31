package com.berisco.qrme.Adapter


//import com.squareup.picasso.Picasso
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.berisco.qrme.Activity_Auth_start
import com.berisco.qrme.Activity_Splash
import com.berisco.qrme.R
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.custom_view_setting.view.*
import java.util.*


class Adapter_Settings(
    private val id: ArrayList<String>,
    private val property_1: ArrayList<String>,
    private val property_2: ArrayList<String>,
    private val property_3: ArrayList<String>,
    private val property_4: ArrayList<String>,
    private val property_6: ArrayList<String>,
    private val property_7: ArrayList<String>,
    private val property_8: ArrayList<String>,
    private val property_5: ArrayList<String>,
    private val title: ArrayList<String>,
    private val isempty: ArrayList<String>,


    private val ctx: Context// , val y : String ,
    //	private val name:ArrayList<String>
) : RecyclerView.Adapter<CustomViewHolder_settings>() {
    override fun getItemCount(): Int {
        return title.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder_settings {

        val layoutInflater = LayoutInflater.from(p0?.context)
        val customview = layoutInflater.inflate(R.layout.custom_view_setting, p0, false)
        return CustomViewHolder_settings(customview)
    }


    override fun onBindViewHolder(holder: CustomViewHolder_settings, position: Int) {

        try {

          //  println("printingxx  (title[position]) " + (title[position]))
            holder.view.title_settings.text = (title[position]).toString()

            //            Picasso.get().load(All_Likes_userImage[position]).into(holder.view.iv_profile_all_like)


            holder.view.tab_setting.setOnClickListener {
                if(position in 0..5){
                    open_link((property_1[position]).toString())
                }
                else if(position == 6){
                    // logout
                    logout()
                }
            }



        } catch (ex: Exception) {
            println("printingxx Exception : NJH33 Adapter " + ex.toString())
        }

    }


    fun open_link(s: String){
        try{

            var url = s

            if (!url.startsWith("http://") && !url.startsWith("https://"))
                url = "http://" + url

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            ctx.startActivity(browserIntent)
        }
        catch (ex: Exception){
            println("Printingxx Exception KLKJ79875 : " + ex.toString())
        }
    }


    fun logout(){
        try{
            AuthUI.getInstance()
                .signOut(ctx)
                .addOnCompleteListener { // user is now signed out
                    Toast.makeText(ctx, "Logged out successfully", Toast.LENGTH_SHORT).show()
                    ctx.startActivity(
                        Intent(
                            ctx,
                            Activity_Splash::class.java
                        )
                    )
                    (ctx as Activity).finishAffinity()
//                    activity?.finish()
                }
        }
        catch (ex: Exception){
            println("Printingxx : Exception JUKH432   $ex")
        }
    }

}

class CustomViewHolder_settings(val view: View) : RecyclerView.ViewHolder(view) {

}