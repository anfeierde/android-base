package com.cz1.rebase_android.ui.base;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.cz1.rebase_android.App;
import com.cz1.rebase_android.di.component.AppComponent;
import com.cz1.rebase_android.listener.PermissionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cz1 on 2017/2/7.
 */

public class BaseActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUESTCODE = 1;   // 请求码

    PermissionListener mPermissionListener;

    public AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }

    /**
     * 注册权限
     * @param permissions  权限集
     * @param permissionListener 权限接口
     */
    protected void requestPermissions(String[] permissions, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;

        List<String> permissionList = new ArrayList<>();  // 存放未获得的权限
        for (String premisiion : permissions) {
            // true : 未获得该权限; false : 已经获得该权限
            if (ContextCompat.checkSelfPermission(this, premisiion)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(premisiion);
            }
        }

        if (permissionList != null && !permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(
                    new String[permissionList.size()]), PERMISSION_REQUESTCODE);
        } else {
            mPermissionListener.Granted();
        }
    }

    /**
     * 注册权限回调
     * @param requestCode  请求码
     * @param permissions  权限集
     * @param grantResults 权限状态
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUESTCODE:
                if (grantResults.length > 0) {
                    List<String> grantPermission = new ArrayList<>();
                    List<String> deinePermisiion = new ArrayList<>();
                    for (int i = 0; i < permissions.length; i++) {
                        int grantresult = grantResults[i];
                        if (grantresult != PackageManager.PERMISSION_GRANTED) {
                            // 授权失败
                            String permission = permissions[i];
                            deinePermisiion.add(permission);
                        } else {
                            // 授权成功
                            String permission = permissions[i];
                            grantPermission.add(permission);
                        }
                    }

                    if (deinePermisiion.isEmpty()) {
                        mPermissionListener.Granted();
                    } else {
                        mPermissionListener.onGrantedPremission(grantPermission);
                        mPermissionListener.onDenierPremission(deinePermisiion);
                    }
                }
                break;
        }
    }


    /**
     * 判断网络状态
     * @return
     */
    public boolean isNetworkConnected() {
        // TODO: 2017/2/7 检查网络状态
        return true;
    }
}
