package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AndroidTests extends TestBase {

    @Test
    void searchTestEn() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    void searchTestRu() {
        $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        $(MobileBy.id("android:id/title")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).sendKeys("Russian");
        $(MobileBy.id("org.wikipedia.alpha:id/language_subtitle")).click();
        $(byClassName("android.widget.ImageButton")).click();
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_lang_button")).shouldHave(Condition.text("RU"));
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Kremlin");
        $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
    }
}



