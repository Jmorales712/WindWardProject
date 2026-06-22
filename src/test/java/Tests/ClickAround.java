package Tests;

import Pages.Home;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class ClickAround extends base.BaseTest {

    @Test
    public void validatePageScrolling(){
        Home home = new Home(page);
        home.navigate();
        page.mouse().wheel(0, 800);

    }

    @Test
    public void validateCondoInsuranceTab(){
        Home home = new Home(page);
        home.navigate();
        new Locator.ScrollIntoViewIfNeededOptions();
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("A decorative icon describing a condo depicted by a building Condominium")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Decorative icon describing a")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View all faqs")).click();
        page.locator("label").filter(new Locator.FilterOptions().setHasText("Condo")).locator("div").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("contact")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("resources").setExact(true)).click();

    }
}
