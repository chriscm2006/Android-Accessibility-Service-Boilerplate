package com.moba11y.basicaccessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.nfc.tech.Ndef;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

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

        switch (event.getEventType()) {
            //On Gesture events print out the entire view heirarchy!
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
                CLog.d(A11yNodeInfo.wrap(getRootInActiveWindow()).toViewHeirarchy());

            default: {
                //If the event has a source, let's print it out separately.
                if (event.getSource() != null) {
                    CLog.d(A11yNodeInfo.wrap(event.getSource()).toViewHeirarchy());
                }
            }
        }
    }

    @Override
    public void onInterrupt() {
        CLog.e("Service Interrupted: Have never actually had this happen.");
    }
}
