package com.example.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * 所有活动的父类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.example.broadcastbestpractice.BaseActivity.java
 * @author: yyxyz
 * @date: 2016-04-15 14:09
 */
public class BaseActivity extends Activity {
    private static final String TAG = "BaseActivity";

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        ActivityCollector.addActivity(this);
    }

    public void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
