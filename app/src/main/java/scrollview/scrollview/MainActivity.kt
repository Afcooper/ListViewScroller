package scrollview.scrollview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val main_rivenview = findViewById<ListView>(R.id.rivenView)

        main_rivenview.adapter = MyCustomAdapter(this)//put my custom adapter there
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter() {

        //val redColor = Color.parseColor("FF0000")
        //val randomColor = Color.parseColor("00FF00")

        private val myContext: Context
        private val championNames = listOf<String>("Akali","Riven","Darius", "Auerelion Sol", "Jax", "Teemo", "Aatrox", "Xayah", "Rakan")

        init {
            myContext = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //val customView = TextView(myContext)
            //customView.text = "TESTING THIS IS A TEST BE CAREFUL"
            val layoutInflater = LayoutInflater.from(myContext)
            val rowMain = layoutInflater.inflate(R.layout.main_row, parent, false)
            val positionTextView = rowMain.findViewById<TextView>(R.id.main_position)
            val mainRowView = rowMain.findViewById<TextView>(R.id.main_row)
            mainRowView.text = championNames.get(position)
            /*if(position % 2 == 0)
            {
                convertView?.setBackgroundColor(redColor)
            }
            else{
                convertView?.setBackgroundColor(randomColor)
            }*/

            positionTextView.text = "Champion #$position"
            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "Oh Hello there" //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()//To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            return championNames.size//To change body of created functions use File | Settings | File Templates.
        }


    }
}
