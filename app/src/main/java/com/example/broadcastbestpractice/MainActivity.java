package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    
        Button forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(v->{
            //插入广播通知用户强制下线， 强制下线的功能不能依附于任何界面，
            // 不管在程序的任何地方，只要发出这样一条广播，就可以完成强制下线了
            Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
            sendBroadcast(intent);

        });
    }
}
