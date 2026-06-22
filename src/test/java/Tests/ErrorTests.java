package Tests;

import Pages.Home;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class ErrorTests extends base.BaseTest {


        //Validate The username/email or password was incorrect error
    @Test
public void validateErrors(){
        Home home = new Home(page);
        home.clickAgentLogin();
        home.enterEmail();
        home.generateRandomPassword();
        home.singInCta();

        PlaywrightAssertions.assertThat
                (page.getByText("The username/email or password was incorrect"))
                .isVisible();
        page.screenshot
                (new Page.ScreenshotOptions().setPath
                        (Paths.get("Errorscreenshot.png")));

}

        // Validate Username and password input error
        @Test
        public void errorValidator () {
        Home home = new Home(page);
        home.navigate();
        home.clickAgentLogin();
        home.singInCta();

                PlaywrightAssertions.
                        assertThat(page.getByText("Please enter User Name")).isVisible();

                PlaywrightAssertions.
                        assertThat(page.getByText("Please enter Password")).isVisible();

                page.screenshot
                        (new Page.ScreenshotOptions().setPath
                                (Paths.get("EPcreenshot.png")));
}

        @Test
        public void validateAgentSignUp (){
            Home home = new Home(page);
            home.navigate();
            home.clickAgentLogin();

        }

        @Test
        public void validateAgentNumberError (){
        Home home = new Home(page);
        home.navigate();
        home.clickAgentLogin();
        home.signUpCta();
        home.registerYourAccount();

        PlaywrightAssertions.assertThat(page.getByText("Agent Number is required.")).isVisible();


        }

        @Test
        public void validateAgentTaxIdError (){
            Home home = new Home(page);
            home.navigate();
            home.clickAgentLogin();
            home.signUpCta();
            home.registerYourAccount();
            home.taxId();

                PlaywrightAssertions.assertThat(page.getByText("Tax ID (FEIN) is required.")).isVisible();


        }
    }
