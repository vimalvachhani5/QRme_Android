package com.berisco.qrme.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berisco.qrme.Adapter.Adapter_Settings
import com.berisco.qrme.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    var adapt_best_selling: Adapter_Settings? = null

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


    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)



        return root
    }


    override fun onStart() {
        super.onStart()

        //  this.supportActionBar?.hide()
        initializeadapter()

    }


    fun initializeadapter() {
        try {

            id.clear()
            property_1.clear()
            property_2.clear()
            property_3.clear()
            property_4.clear()
            property_6.clear()
            property_7.clear()
            property_8.clear()
            property_5.clear()
            title.clear()
            isempty.clear()

            try {

                recyclerview_settings.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL, false
                )

                adapt_best_selling =
                    Adapter_Settings(
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

                        requireContext()
                    )
                recyclerview_settings.adapter = adapt_best_selling


                get_sample_data()

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
        while(i<=7){

            if (i==0){
                title.add("FAQ")
                id.add("0")
                property_1.add(this.getString(R.string.link_faq))
            }
            else if (i== 1 ){
                title.add("Feedback")
                id.add("1")
                property_1.add(this.getString(R.string.link_feedback))
            }
            else if (i== 2 ){
                title.add("Privacy Policy")
                id.add("2")
                property_1.add(this.getString(R.string.link_privacy_policy))
            }
            else if (i== 3 ){
                title.add("Terms")
                id.add("3")
                property_1.add(this.getString(R.string.link_terms))
            }
            else if (i== 4 ){
                title.add("Share app")
                id.add("4")
                property_1.add(this.getString(R.string.link_share_app_link))
            }
            else if (i== 5 ){
                title.add("Rate App")
                id.add("5")
                property_1.add(this.getString(R.string.link_rate_app_link))
            }

            else if (i== 6 ){
                title.add("Logout")
                id.add("5")
                property_1.add("Sample")
            }



            property_2.add("Sample")
            property_3.add("Sample")
            property_4.add("Sample")
            property_6.add("Sample")
            property_7.add("Sample")
            isempty.add("Sample")
            property_8.add("Sample")
            property_5.add("Sample")


            i++


        }


        //activity!!.runOnUiThread(Runnable {

        adapt_best_selling!!.notifyDataSetChanged()
        //  progressDialog.stop_progress_dialog()


        //  })


    }




}