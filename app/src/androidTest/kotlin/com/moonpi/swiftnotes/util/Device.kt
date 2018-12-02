@file:JvmName("Devices")

package com.moonpi.swiftnotes.util

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice

//TODO (2.1 Unitily) target context will never be used
val targetContext: Context
    get() = InstrumentationRegistry.getInstrumentation().targetContext

//TODO (2.2 Unitily) in contrast to testing context
val context: Context
    get() = InstrumentationRegistry.getInstrumentation().context

//TODO (2.3 Unitily) phone/emulator
fun getDevice(): UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())