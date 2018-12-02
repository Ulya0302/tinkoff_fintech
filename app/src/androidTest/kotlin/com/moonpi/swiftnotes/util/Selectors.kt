@file:JvmName("Selectors")

package com.moonpi.swiftnotes.util

import android.support.annotation.IdRes
import android.support.test.uiautomator.By
import android.support.test.uiautomator.BySelector
import android.support.test.uiautomator.UiObject2
import android.support.test.uiautomator.Until
import java.util.concurrent.TimeUnit

private val timeout = TimeUnit.SECONDS.toMillis(5)

fun byRes(@IdRes resId: Int): BySelector = By.res(targetContext.resources.getResourceName(resId))

fun byPackage(packageName: String): BySelector = By.pkg(packageName)

fun byStringRes(resString: String): BySelector = By.res(resString)

fun byStringText(text: String): BySelector = By.text(text)

fun byContentDesc(text: String): BySelector = By.desc(text)

fun byClass(text: String): BySelector = By.clazz(text)

fun BySelector.waitFindObject(): UiObject2 =
        getDevice().wait(Until.findObject(this), timeout)

fun BySelector.waitHasObject(): Boolean =
        getDevice().wait(Until.hasObject(this), timeout)

fun BySelector.waitFindObjects(): List<UiObject2> =
        getDevice().wait(Until.findObjects(this), timeout)



