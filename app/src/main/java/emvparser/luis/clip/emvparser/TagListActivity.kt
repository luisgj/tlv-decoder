package emvparser.luis.clip.emvparser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import emvparser.luis.clip.emvparser.common.Constants
import kotlinx.android.synthetic.main.activity_main.*
import emvparser.luis.clip.emvparser.common.EMVParser

class TagListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.decoded_data_list)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun decodeAndShow(tag: String) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.example_1 -> {

            }
            R.id.example_2 -> {

            }

        }
    }
}
