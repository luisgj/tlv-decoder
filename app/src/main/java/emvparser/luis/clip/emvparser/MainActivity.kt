package emvparser.luis.clip.emvparser

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import emvparser.luis.clip.emvparser.common.EMVParser
import emvparser.luis.clip.emvparser.models.Tag
import emvparser.luis.clip.emvparser.common.Constants
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val _parser: EMVParser = EMVParser()
    private val _argsBundle: Bundle = Bundle()
    private val _tagListFragment: TagListDialogFragment = TagListDialogFragment()
    private val _fm = this@MainActivity.fragmentManager
    private var _tagList: ArrayList<Tag>? = null
    private var _mediumFont: Typeface? = null
    private var _regularFont: Typeface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        this.initEvents()
        this.initResources()
        this.initGUI()
    }

    private fun initEvents() {
        example_1.setOnClickListener(this)
        example_2.setOnClickListener(this)
        whatever.setOnClickListener(this)
    }

    private fun initResources() {
        _mediumFont  = ResourcesCompat.getFont(this, R.font.dinpro_medium)
        _regularFont = ResourcesCompat.getFont(this, R.font.dinpro_regular)
        input_tlv.setBackgroundResource(R.drawable.border_gray)
    }

    private fun initGUI() {
        greetings.typeface = _mediumFont
        explain.typeface   = _regularFont
        check_it.typeface  = _regularFont
        example_1.typeface = _mediumFont
        example_2.typeface = _mediumFont
        whatever.typeface  = _mediumFont
    }

    private fun decodeAndShow(tag: String) {
        try {
            _tagList = _parser.decodeTLV(tag)
            _argsBundle.putParcelableArrayList("tagList",_tagList)
            _tagListFragment.arguments = _argsBundle
            _tagListFragment.show(_fm, "tlvList")
        } catch (e: Exception) {
            alert("The value cant be translated to any valid EMV transaction")
                    .show()
        }
    }

    private fun validateAndParse() {
        val textValue = input_tlv.text.toString()
        if(!textValue.equals("")) {
            decodeAndShow(textValue)
        } else {
            input_tlv.setBackgroundResource(R.drawable.border_error)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.example_1 -> {
                decodeAndShow(Constants.CHIPCARD1)
            }
            R.id.example_2 -> {
                decodeAndShow(Constants.CHIPCARD2)
            }
            R.id.whatever -> {
                validateAndParse()
            }
        }
    }
}
