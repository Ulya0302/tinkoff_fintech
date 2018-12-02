package com.moonpi.swiftnotes.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestSuit : AbstractTest() {

    @Test
    fun testCase1() {
        app.checkTitle("Swiftnotes")
        app.checkTextAddNewNote("Press '+' to add new note")
        app.checkAddNewNoteButton()
        app.clickOnAddNewNoteButton()
        app.checkEditTitle("Title")
        app.checkEditNote("Note")
        app.clickBack()
        app.checkSaveChangesText("Save changes?")
        app.checkYesNoButtons()
        app.clickNoButton()
        app.checkTitle("Swiftnotes")
    }

    @Test
    fun testCase2() {
        app.clickOnAddNewNoteButton()
        app.typeInTitle("1")
        app.typeInNote("1")
        app.clickBack()
        app.clickYesButton()
        app.checkTitleNote("1")
        app.checkBodyNote("1")
    }

    @Test
    fun testCase3() {
        app.clickMenuButton()
        app.checkBackupButton("Backup notes")
        app.checkRateButton("Rate app")
        app.checkRestoreButton("Restore notes")
        app.codeViti()
        app.pressBack()
        app.clickOnAddNewNoteButton()
        app.clickMenuButton()
        app.checkFontSizeButton("Note font size")
        app.checkHideBodyButton("Hide note body in list")
    }
}
