package com.example.rts.firstcode;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RTS on 2018/8/6.
 */

public class ActivityCollecter {
    public static List<Activity>activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void finishAll() {
        for (Activity activity:activities){
            if (activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
