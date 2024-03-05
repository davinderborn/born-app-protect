package com.bornappprotect


import android.view.WindowManager

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class BornAppProtectModule(private val reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {
  companion object {
    const val NAME = "BornAppProtect"
  }

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun enabledSecuring(_enable: Boolean) {
    if (reactContext.hasCurrentActivity()) {
      val activity = reactContext.currentActivity
      if (activity != null) {
        if (_enable) {
          activity.runOnUiThread(Runnable {
            reactContext.currentActivity!!.window.setFlags(
              WindowManager.LayoutParams.FLAG_SECURE,
              WindowManager.LayoutParams.FLAG_SECURE
            )
          })
        } else {
          activity.runOnUiThread(Runnable {
            reactContext.currentActivity!!.window.clearFlags(
              WindowManager.LayoutParams.FLAG_SECURE
            )
          })
        }
      }
    }
  }

  @ReactMethod
  fun enableSecureView() {
    if (reactContext.hasCurrentActivity()) {
      val activity = reactContext.currentActivity
      activity?.runOnUiThread {
        reactContext.currentActivity!!.window.setFlags(
          WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE
        )
      }
    }
  }

  @ReactMethod
  fun disableSecureView() {
    if (reactContext.hasCurrentActivity()) {
      val activity = reactContext.currentActivity
      activity?.runOnUiThread { reactContext.currentActivity!!.window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE) }
    }
  }

}
