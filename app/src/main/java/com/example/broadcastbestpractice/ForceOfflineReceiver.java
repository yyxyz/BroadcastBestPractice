package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.example.broadcastbestpractice.ForceOfflineReceiver.java
 * @author: yyxyz
 * @date: 2016-04-15 15:03
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    private static final String TAG = "ForceOfflineReceiver";

    public void onReceive(final Context context, Intent intent) {
        // 构建一个对话框
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Waring");
        dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
        // 设置对话框不可取消
        dialogBuilder.setCancelable(false);
        //注册对话框的确定按钮
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();//销毁所有活动
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);  //重新启动LoginActivity
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        //设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }

}

