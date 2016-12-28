package com.example.runtimepermissions;

import java.util.List;

/**
 * Created by zhang on 2016/12/28.
 */

public interface PermissionListener {

    /**
     * 授权回调
     */
    void granted();

    /**
     * 拒绝回调
     * @param deniedPermission 被拒绝的授权
     */
    void denied(List<String> deniedPermission);
}
