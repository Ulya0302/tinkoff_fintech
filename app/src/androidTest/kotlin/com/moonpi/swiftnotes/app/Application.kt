package com.moonpi.swiftnotes.app

import android.os.Environment
import android.support.test.uiautomator.UiObject2
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.util.*
import org.junit.Assert.assertTrue
import java.io.File


class Application  {

    private val newNoteButtonID = R.id.newNote
    private val textIfNoNotesID = R.string.no_notes_text
    private val applicationTitleID = R.string.app_name
    private val editNoteTitleID = R.id.titleEdit
    private val editNoteBodyID = R.id.bodyEdit
    private val saveChangesTextID = R.string.dialog_save_changes
    private val backupButtonTextID = R.string.action_backup
    private val restoreButtonTextID = R.string.action_restore
    private val rateButtonTextID = R.string.action_rate_app
    private val fontSizeButtonTextID = R.string.action_font_size
    private val hideBodyTextID = R.string.action_hide_body

    private val buttonBackSelector = byClass("android.widget.ImageButton")
    private val yesButtonSelector = byStringRes("android:id/button1")
    private val noButtonSelector = byStringRes("android:id/button2")
    private val titleNoteSelector = byStringRes("com.moonpi.swiftnotes:id/titleView")
    private val bodyNoteSelector = byStringRes("com.moonpi.swiftnotes:id/bodyView")
    private val menuButtonSelector = byContentDesc("Ещё")


    fun deleteOldResults() {
        val resultPath = File(Environment.getExternalStorageDirectory()
                .absolutePath + "/allure-results")
        if (resultPath.exists()) {
            resultPath.deleteRecursively()
        }
    }


    fun checkTitle(text: String) {
        checkTextWithText(applicationTitleID, text)
    }

    fun checkTextAddNewNote(text: String) {
        checkTextWithText(textIfNoNotesID, text)
    }

    fun checkAddNewNoteButton() {
        checkEnabledByID(newNoteButtonID)
    }

    fun clickOnAddNewNoteButton() {
        clickWithId(newNoteButtonID)
    }

    fun checkEditTitle(text: String) {
        checkHintWithId(editNoteTitleID, text)
    }

    fun checkEditNote(text: String) {
        checkHintWithId(editNoteBodyID, text)
    }

    fun clickBack() {
        buttonBackSelector.waitFindObject().click()
    }

    fun checkSaveChangesText(text: String) {
        checkTextWithText(saveChangesTextID, text)
    }

    fun checkYesNoButtons() {
        assertTrue(yesButtonSelector.waitFindObject().text == "Yes")
        assertTrue(noButtonSelector.waitFindObject().text == "No")
    }

    fun clickYesButton() {
        yesButtonSelector.waitFindObject().click()
    }

    fun clickNoButton() {
        noButtonSelector.waitFindObject().click()
    }

    fun typeInTitle(text: String) {
        typeString(editNoteTitleID, text)
    }

    fun typeInNote(text: String) {
        typeString(editNoteBodyID, text)
    }

    fun checkTitleNote(text: String) {
        val elements: List<UiObject2> = titleNoteSelector.waitFindObjects()
        assertTrue(elements[0].text == text)
    }

    fun checkBodyNote(text: String) {
        val elements: List<UiObject2> = bodyNoteSelector.waitFindObjects()
        assertTrue(elements[0].text == text)
    }

    fun clickMenuButton() {
        menuButtonSelector.waitFindObject().click()
    }

    fun checkBackupButton(text: String) {
        checkButton(backupButtonTextID, text)
    }

    fun checkRestoreButton(text: String) {
        checkButton(restoreButtonTextID, text)
    }

    fun checkRateButton(text: String) {
        checkButton(rateButtonTextID, text)
    }

    fun checkFontSizeButton(text: String) {
        checkButton(fontSizeButtonTextID, text)
    }

    fun checkHideBodyButton(text: String) {
        checkButton(hideBodyTextID, text)
    }


    fun pressBack() {
        getDevice().pressBack()
    }
    private fun checkButton(elementID : Int, text: String) {
        checkDisplayedWithText(elementID)
        checkEnabledWithText(elementID)
        checkTextWithText(elementID, text)
    }
}