package com.cz1.rebase_android.listener;

import java.util.List;

/**
 * Created by cz1 on 2017/2/7.
 */

public interface PermissionListener {

    // authorization granted
    void Granted();

    // onGranted callback
    void onGrantedPremission(List<String> permissions);

    // onDenier callback
    void onDenierPremission(List<String> permissions);
}
