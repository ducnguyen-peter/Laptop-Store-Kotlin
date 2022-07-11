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
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.model.item.Item
import java.io.IOException
import java.net.URL
import java.util.*

class GridItemAdapter(private val context: Context, private val listItem: ArrayList<Item>)
    : BaseAdapter() {

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
        val view: View by lazy {
            (context as Activity).layoutInflater.inflate(R.layout.grid_item, p2, false)
        }
        val viewHolder = ViewHolder()

        viewHolder.txtItemName = view.findViewById(R.id.lblItemName)
        viewHolder.txtItemPrice = view.findViewById(R.id.lblItemPrice)
        viewHolder.imgItem = view.findViewById(R.id.imgItem)

        viewHolder.txtItemName?.apply {
            text = item.name
        }
        viewHolder.txtItemPrice?.apply {
            text = String.format(Locale.ENGLISH, "%.1f$", item.price)
        }
        viewHolder.imgItem?.apply {
            val url = if(item.images.size!=0){
                item.images[0]
            } else "https://cdn3.vectorstock.com/i/1000x1000/42/57/abstract-creative-laptop-isometric-template-3d-vector-31074257.jpg"
            val bitMapUrlTask = GetBitMapUrlTask(url)
            bitMapUrlTask.start()
            setImageBitmap(bitMapUrlTask.bitMap)
        }
        print("""item name: ${viewHolder.txtItemName?.text}
            item price: ${viewHolder.txtItemPrice?.text}
        """)
        return view
    }

    private class ViewHolder {
        var txtItemName: TextView? = null
        var txtItemPrice: TextView? = null
        var imgItem: ImageView? = null
    }

    private class GetBitMapUrlTask(private val url: String) : Thread() {
        @Volatile
        var bitMap: Bitmap? = null
        override fun run() {
            try {
                bitMap = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(URL(url).openStream()), 120, 120, false)
            } catch (e: IOException) {
                Log.e("getBitMapFromUrl", "Error when getting image", e)
                e.printStackTrace()
            }
        }
    }
}