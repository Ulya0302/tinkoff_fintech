package com.moonpi.swiftnotes.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@DisplayName("Тесты для Swiftnotes")
class TestSuit : AbstractTest() {

    @Test
    @DisplayName("Проверка основных элементов на экране")
    fun checkMainElementsTest() {
        step("Проверка на главном экране наличия основных элементов") {
            app.checkTitle("Swiftnotes")
            app.checkTextAddNewNote("Press '+' to add new note")
            app.checkAddNewNoteButton()
            deviceScreenshot("Главный экран")
        }
        step("Нажатие на '+'. Проверка заголовка и надписи") {
            app.clickOnAddNewNoteButton()
            app.checkEditTitle("Title")
            app.checkEditNote("Note")
            deviceScreenshot("Экран создания заметки")
        }
        step("Нажатие на '<-'. Проверка надписи Save changes и кнопок") {
            app.clickBack()
            app.checkSaveChangesText("Save changes?")
            app.checkYesNoButtons()
            deviceScreenshot("Подтверждение сохранения")
        }
        step("Нажатие на кнопку 'Нет'. Проверка нахождения на главном экране") {
            app.clickNoButton()
            app.checkTitle("Swiftnotes")
            deviceScreenshot("Главный экран")
        }
    }

    @Test
    @DisplayName("Тестирование создания заметки")
    fun creatingNoteTest() {
        step("Нажатие на кнопку '+'. Ввод '1' в заголовок и тело") {
            app.clickOnAddNewNoteButton()
            app.typeInTitle("1")
            app.typeInNote("1")
            deviceScreenshot("Экран создания заметки")
        }
        step("Нажатие на кнопку '<-'. Проверка появления надписи Save changes? ") {
            app.clickBack()
            app.checkSaveChangesText("Save changes?")
            deviceScreenshot("Экран подтверждения сохранения")
        }
        step("Нажимаем на кнопку Yes. " +
                "Проверяем наличие заметки с заголовком и текстом '1'") {
            app.clickYesButton()
            app.checkTitleNote("1")
            app.checkBodyNote("1")
            deviceScreenshot("Главный экран")
        }
    }

    @Test
    @DisplayName("Проверка кнопок в меню")
    fun checkMenusTest() {
        step("Нажатие на кнопку меню. Проверка видимости, активности трех кнопок " +
                "и совпадения текста на них.") {
            app.clickMenuButton()
            app.checkBackupButton("Backup notes")
            app.checkRateButton("Rate app")
            app.checkRestoreButton("Restore notes")
            deviceScreenshot("Меню на главном экране")
        }
        step("Переход к экрану редактирования") {
            app.pressBack()
            app.clickOnAddNewNoteButton()
            deviceScreenshot("Экран создания заметки")
        }
       step("Проверка кнопок в меню.") {
           app.clickMenuButton()
           app.checkFontSizeButton("Note font size")
           app.checkHideBodyButton("Hide note body in list")
           deviceScreenshot("Меню на экране создания заметки")
       }
    }
}
