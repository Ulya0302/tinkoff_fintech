package com.moonpi.swiftnotes.test

import android.os.Environment
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
open class AbstractTest {
    val app = com.moonpi.swiftnotes.app.Application()

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun clearUserData() {
        val appPath = InstrumentationRegistry.getTargetContext().filesDir.parentFile

        if (appPath.exists()) {
            val childList = appPath.list()
            for (child in childList) {
                if (child != "lib") {
                    File(appPath, child).deleteRecursively()
                }
            }
        }
    }

    open fun deleteOldResults() {
        val resultPath = File(Environment.getExternalStorageDirectory()
                .absolutePath + "/allure-results")
        if (resultPath.exists()) {
            resultPath.deleteRecursively()
        }
    }


}