package com.example.laptopstorekotlin.view.user.main.activities

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.databinding.GridItemBinding
import com.example.laptopstorekotlin.model.item.Item
import java.io.IOException
import java.net.URL
import java.util.*

class GridItemAdapter(val context:Context,val listItem:ArrayList<Item>): BaseAdapter() {

    override fun getCount(): Int {
        return listItem.size
    }

    override fun getItem(p0: Int): Any {
        return listItem[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = listItem[p0]
        val view:View by lazy {
            (context as Activity).layoutInflater.inflate(R.layout.grid_item, p2, false)
        }
        val viewbinding : GridItemBinding = DataBindingUtil.setContentView(context as MainActivity, R.layout.grid_item)
        viewbinding.lblItemName.text = item.name
        viewbinding.lblItemPrice.text = String.format(Locale.ENGLISH, "%.1f$", item.price)
        viewbinding.imgItem.apply {
            val bitmapTask = GetBitMapUrlTask(item.resizedImage.w150)
            bitmapTask.run()
            setImageBitmap(bitmapTask.bitMap)
        }
        return view
    }

    private class GetBitMapUrlTask(private val url: String) : Runnable {
        @Volatile
        var bitMap: Bitmap? = null
            private set
        override fun run() {
            try {
                bitMap = BitmapFactory.decodeStream(URL(url).openStream())
            } catch (e: IOException) {
                Log.e("getBitMapFromUrl", "Error when getting image", e)
                e.printStackTrace()
            }
        }
    }
}