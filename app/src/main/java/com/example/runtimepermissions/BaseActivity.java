package com.example.runtimepermissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2016/12/28.
 */

public class BaseActivity extends AppCompatActivity {


    private PermissionListener mPermissionListener;

    public void requestRuntimePermissions(String[] permissions, PermissionListener permissionListener){

        mPermissionListener = permissionListener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        if (!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            mPermissionListener.granted();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                List<String> mDeniedList = new ArrayList<>();
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        mDeniedList.add(permission);
                    }
                }

                if (mDeniedList.isEmpty()) {
                    mPermissionListener.granted();
                } else {
                    mPermissionListener.denied(mDeniedList);
                }

                break;
            default:
                break;
        }
    }
}
