package com.moba11y.basiceaccessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import com.chriscm.clog.*;
import com.moba11y.androida11yutils.A11yNodeInfo;

/**
 * Created by chrismcmeeking on 3/3/17.
 */

public class BasicAccessibilityService extends AccessibilityService {

    static {
        CLog.initialize(BasicAccessibilityService.class.getSimpleName(), BuildConfig.DEBUG);
    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        CLog.d(event.toString());
        CLog.d(A11yNodeInfo.wrap(getRootInActiveWindow()).toViewHeirarchy());
    }

    @Override
    public void onInterrupt() {
        CLog.e("Service Interrupted: Have never actually had this happen.");
    }
}
