package com.xzy.test
import android.content.Intent
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import com.xzy.test.activity.ActivityUtilsTest
import com.xzy.test.app.AppUtilsActivity
import com.xzy.test.constant.Configs
import com.xzy.test.constant.Per
import com.xzy.test.xml.XmlUtilsTest
import com.xzy.utils.activity.ActivityUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * 程序入口,包含测试用例入口
 * @author xzy
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Per.isGrantExternalRW(this)
        initView()
    }

    private fun initView() {
        val simpleAdapter = SimpleAdapter(
                this, getData(), R.layout.gridview_item, arrayOf("text"),
                intArrayOf(R.id.item_tv)
        )
        gridView.adapter = simpleAdapter
        gridView.setOnItemClickListener { _, _, i, _ ->
            when (i) {
                0 -> {
                    // ActivityUtilsTest
                    ActivityUtils.startActivity(Intent(this,
                            ActivityUtilsTest::class.java))
                }
                1 -> {
                    // AdaptScreenUtilsActivity
                    ActivityUtils.startActivity(Intent(this,
                            XmlUtilsTest::class.java))
                }
                2 -> {
                    // AppUtilsActivity
                    ActivityUtils.startActivity(Intent(this,
                            AppUtilsActivity::class.java))
                }

            }
        }
    }

    private fun getData(): List<Map<String, Any>> {
        val dataList = ArrayList<Map<String, Any>>()
        val len = Configs.Number.items.size - 1
        for (i in 0..len) {
            val map = HashMap<String, Any>()
            map["text"] = Configs.Number.items[i]
            dataList.add(map)
        }
        return dataList
    }

}
