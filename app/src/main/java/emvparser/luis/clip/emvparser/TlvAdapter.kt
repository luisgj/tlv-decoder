package emvparser.luis.clip.emvparser

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import emvparser.luis.clip.emvparser.models.Tag


class TlvAdapter(context: Context,tagList: ArrayList<Tag>, regularFont: Typeface?) : BaseAdapter() {

    private var _tagList = tagList
    private val _mInflator: LayoutInflater
    private val _regularFont = regularFont

    init {
        _mInflator = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ViewHolder

        if (convertView == null) {
            view = _mInflator.inflate(R.layout.tlv_row, parent, false)
            vh = ViewHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.tvTag.text = _tagList.get(position).getModelTag()
        vh.tvValue.text = _tagList.get(position).getModelValue()
        vh.tvTag.typeface = _regularFont
        vh.tvValue.typeface = _regularFont

        return view
    }

    override fun getItem(position: Int): Any {
        return _tagList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return _tagList.size
    }

    private class ViewHolder(view: View?) {
        val tvTag: TextView
        val tvValue: TextView

        init {
            this.tvTag = view?.findViewById<TextView>(R.id.tag_label) as TextView
            this.tvValue = view?.findViewById<TextView>(R.id.value_label) as TextView
        }


    }
}