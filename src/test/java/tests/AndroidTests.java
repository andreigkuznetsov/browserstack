package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Поиск на английском языке в приложении Wikipedia")
    void searchTestEn() {

        step("Открываем строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Вводим поисковое слово", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Проверяем, что в результатах поиска есть значения", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Переключение поиска на русский язык и поиск в приложении Wikipedia")
    void searchTestRu() {

        step("Открываем меню Settings", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });

        step("Изменяем язык поиска на русский", () -> {
            $(MobileBy.id("android:id/title")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).sendKeys("Russian");
            $(MobileBy.id("org.wikipedia.alpha:id/language_subtitle")).click();
        });

        step("Возвращаемся на экран со строкой поиска", () -> {
            $(byClassName("android.widget.ImageButton")).click();
        });

        step("Открываем строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Убеждаемся, что язык переключен на русский", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_lang_button")).shouldHave(Condition.text("RU"));
        });

        step("Вводим поисковое слово", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Кремль");
        });

        step("Проверяем, что в результатах поиска есть значения", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }
}



