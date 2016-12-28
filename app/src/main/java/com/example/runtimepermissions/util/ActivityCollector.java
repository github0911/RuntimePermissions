package com.example.runtimepermissions.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2016/12/28.
 */

public class ActivityCollector {

    private static List<Activity> mActivityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        mActivityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        mActivityList.remove(activity);
    }

    public static Activity getTopActivity(){
        if (mActivityList.isEmpty()){
            return null;
        } else {
            return mActivityList.get(mActivityList.size() - 1);
        }
    }
}
