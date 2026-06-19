package Tests;

import Pages.Home;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class HomeTests extends base.BaseTest {


    // Verify SearchBox Inputs
    @Test
public void testSearchOnHomePage () {
        Home home = new Home(page);
        home.navigate();
        home.search("Home insurance quote Delray Beach");

    }

    // Verify Get A Quote Button Is Clickable & Lands On The Correct URL
    @Test
    public void testGetQuoteButton() {
        Home home = new Home(page);
        home.navigate();
        home.clickGetQuote();
        PlaywrightAssertions.assertThat(page).hasURL("https://www.windwardrisk.com/get-a-quote");

    }

    // Verify Agent Login Is Clickable & Lands On The Correct URL
    @Test
    public void testAgentLogin (){
        Home home =  new Home(page);
        home.navigate();
        home.clickAgentLogin();
        PlaywrightAssertions.assertThat(page).hasURL("https://portal.windwardrisk.com/Login");

    }

    //Verify For HomeOwners Dropdown Opens
    @Test
    public void testHomeOwnersButton (){
        Home home = new Home(page);
        home.navigate();
        home.clickOnForHomeOwners();

    }


    //Verify Partner Images Are Visible
    @Test
    public void testHomePageImagesPresent(){
        Home home = new Home(page);
        home.navigate();
        home.validateLogosAreVisible();
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("logoscreenshot.png")));
        System.out.println("all 3 are visible");


    }

    @Test
    public void validateFindAnAgent () {
        Home home = new Home(page);
        home.navigate();
        home.findAnAgentButton();
        PlaywrightAssertions.assertThat(page).hasURL("https://www.windwardrisk.com/for-homeowners/find-an-agent");

    }

}