package base;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.List;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        playwright
                = Playwright.create();
        browser
                = playwright.chromium().launch
                (new BrowserType.LaunchOptions().
                        setHeadless(false).
                        setSlowMo(3000).
                        setArgs(List.of("--disable-blink-features=AutomationControlled")));
        context
                = browser.newContext();

        page
                = context.newPage();

        page.navigate("https://www.windwardrisk.com/");

    }

    @AfterMethod
    public void tearDown() {

        if (context != null) context.close();
        if(browser != null) browser.close();
        if (playwright != null) playwright.close();

    }
}
