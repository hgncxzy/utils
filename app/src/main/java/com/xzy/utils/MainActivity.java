package com.xzy.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xzy.utils.toast.T;
import com.xzy.utils.xml.XmlUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private void test() {
        Document doc = null;
        try {
            FileInputStream fis = new FileInputStream
                    ("C:\\xzy_git_projects\\utils\\app\\src\\main\\java\\com\\xzy\\utils\\xml\\test.xml");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            String str = new String(b);
            doc = DocumentHelper.parseText(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = XmlUtils.Dom2Map(doc);
        T.showShort(this, (String) map.get("name"));
    }
}
