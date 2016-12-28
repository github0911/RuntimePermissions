package com.example.runtimepermissions;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.request_permission)
    Button requestPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.request_permission)
    public void requestPermission(){
        requestRuntimePermissions(new String[]{Manifest.permission.CALL_PHONE}, new PermissionListener() {
            @Override
            public void granted() {

            }

            @Override
            public void denied(List<String> deniedPermission) {

            }
        });
    }
}
