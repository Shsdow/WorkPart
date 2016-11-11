package com.mk.workdemo.Activities;

import java.util.ArrayList;
import java.util.List;

/**
 * activity管理类
 */

public class AtyManager {

    private List<BaseAcitivity> acitivityList = new ArrayList<>();
    private static AtyManager atyManager = null;

    public static synchronized AtyManager INSTANCE() {
        if (atyManager == null) {
            synchronized (AtyManager.class) {
                atyManager = new AtyManager();
            }
        }
        return atyManager;
    }

    public void addActivity(BaseAcitivity baseAcitivity) {
        acitivityList.add(baseAcitivity);
    }

    public BaseAcitivity currentActivity() {
        return acitivityList.isEmpty() ? null : acitivityList.get(acitivityList.lastIndexOf(acitivityList));
//        return acitivityList.isEmpty() ? null : acitivityList.get(acitivityList.size()-1);
    }

    /**
     * 正确性待议
     *
     * @param clzz
     * @return
     */
    public BaseAcitivity findActivity(Class clzz) {
        BaseAcitivity acitivity = null;
        for (BaseAcitivity aty : acitivityList) {
            if (aty.getClass() == clzz) {
                acitivity = aty;
                break;
            }
        }
        return acitivity;
    }

    public void removeActivity(BaseAcitivity baseAty) {
        acitivityList.remove(baseAty);
    }

    public void finishActivity(BaseAcitivity baseAty) {
        if (baseAty != null) {
            acitivityList.remove(baseAty);
            baseAty.finish();
        }
    }

    public void finishActivity(Class clazz) {
        for (BaseAcitivity baseAty : acitivityList) {
            if (baseAty.getClass() == clazz) {
                finishActivity(baseAty);
            }
        }
    }

    public void finishAllActivity() {
        for (BaseAcitivity baseAty : acitivityList) {
            if (!baseAty.isFinishing()) {
                baseAty.finish();
            }
        }
        acitivityList.clear();
    }
}
