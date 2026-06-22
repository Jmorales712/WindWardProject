package Tests;

import Pages.Home;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import java.util.Locale;

public class SmokeTests extends base.BaseTest {



    @Test
    public void validateNavigationTitle (){
        Home home = new Home (page);
        home.navigate();

        PlaywrightAssertions.assertThat(page).hasTitle("Home Insurance Management | Windward Risk Managers");

    }

    @Test
    public void validateHeaderNavigationVisible() {
        Home home = new Home(page);
        home.navigate();
        home.validateHeaderNavigationVisible();

    }

    @Test
    public void validateGetQuoteButton (){
        Home home = new Home (page);
        home.navigate();
        home.getQuoteHeaderCta();
        PlaywrightAssertions.assertThat(page).hasTitle("Get An Insurance Quote | Windward Risk Managers");
    }

    @Test
    public void validateChatBot () {
        Home home = new Home(page);
        home.navigate();
        home.getQuoteHeaderCta();

         Locator chatBox =
                page.locator("iframe[title='Windward Risk Managers Quoting System']")
                .contentFrame()
                        .locator("span");

         chatBox.scrollIntoViewIfNeeded();
         chatBox.click();

         PlaywrightAssertions.assertThat(chatBox).isVisible();


    }
}
