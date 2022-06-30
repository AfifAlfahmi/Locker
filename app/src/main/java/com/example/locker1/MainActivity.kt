package com.example.locker1

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_ticket.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T










class MainActivity : AppCompatActivity() {

    var adapter:appsAdapter?=null
    var  listof_apps = ArrayList<String>()
   lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      // intent = packageManager().getLaunchIntentForPackage("com.whatsapp")
     btn=findViewById(R.id.btn_whats)


        //var launchIntent: Intent? = null
        //try {
           // launchIntent = packageManager.getLaunchIntentForPackage("com.instagram.android")
            //val intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp")
           // if(launchIntent == null){
              //  startActivity(intent)
          //  }


       // } catch (ignored: Exception) { }


        btn_whats.setOnClickListener{










            try {
                val apppackage = "com.instagram.android"

                val cx = this
                val intent = cx.getPackageManager().getLaunchIntentForPackage(apppackage)
                startActivity(intent)
           } catch (e: Exception) {
                Toast.makeText(this, "Sorry, Instagram Apps Not Found", Toast.LENGTH_LONG).show()
            }


        }

        val packagelist = packageManager.getInstalledPackages(0)

         var id:Int =0
        for (item in packagelist) {

          var   packInfo:PackageInfo  =packagelist.get(id)

           val appName = packInfo.applicationInfo.loadLabel(getPackageManager()).toString()



            listof_apps.add(appName)

            id++


        }










        adapter = appsAdapter(listof_apps,this)
        list_view.adapter =adapter



    }



}




