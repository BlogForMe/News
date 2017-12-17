package com.jonzhou.nytime.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class DeviceInfo {

    public static String apkKey = "e4f505f73a9f4ee99119ab33a19ab05e";

    public static int loadVersionInfo(Context context) {
        int versionCode = 0;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (pi != null) {
                versionCode = pi.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
