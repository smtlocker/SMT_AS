package com.smt.smt_as.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PhoneUtils {
    // 전화 정보 가져오기
    public static String getPhoneNumber(Context context, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // 권한이 허용되지 않은 경우, 권한 요청
            ActivityCompat.requestPermissions((Activity) activity, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS}, 0);
            return "null";
        } else {
            // 권한이 허용된 경우, 전화번호 가져오기
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {
                String phoneNumber = telephonyManager.getLine1Number();
                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    return phoneNumber;
                }
            }
        }
        return null;

    }


}
