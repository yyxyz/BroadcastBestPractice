package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理所有的活动，关闭所有的活动等等。
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.example.broadcastbestpractice.ActivityCollector.java
 * @author: yyxyz
 * @date: 2016-04-15 11:30
 */
public class ActivityCollector {
    private static final String TAG = "ActivityCollector";
    private static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
