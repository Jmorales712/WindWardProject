package Tests;

import Pages.Home;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class ModalsTests extends base.BaseTest {



    // Validate the Modal is opened and closed
    @Test
    public void validateModal1 (){
        Home home = new Home(page);
        home.navigate();
        home.clickAgentLogin();
        home.signUpCta();
        home.registerYourAccount();
        home.questionMarkBox1();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Modal1.png")));
        home.valCancelButton();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ModalClosed.png")));


    }

}
