package com.example.locker1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.app_ticket.view.*

class appsAdapter: BaseAdapter {
    var context: Context?=null
    var  listofAppsLocal = ArrayList<String>()

    constructor(listof_apps:ArrayList<String>, context: Context){
        listofAppsLocal=listof_apps
        this.context=context
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val app = listofAppsLocal[position]

        var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val appView = inflator.inflate(R.layout.app_ticket,null )

        appView.tv_apps.text= app
        return appView

    }

    override fun getItem(position: Int): Any {
        return  listofAppsLocal[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return  listofAppsLocal.size
    }


}