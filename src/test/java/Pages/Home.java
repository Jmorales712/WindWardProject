package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Home {

    // =========================
    // Page Object
    // =========================

    private Page page;

    // =========================
    // Home Page Locators
    // =========================

    private Locator search;
    private Locator getQuote;
    private Locator quoteHeaderCta;
    private Locator agentLogin;
    private Locator forHomeowners;
    private Locator floridaPeninsulaLogo;
    private Locator edisonLogo;
    private Locator ovationLogo;
    private Locator findAnAgent;

    // =========================
    // Agent Login / Sign Up Locators
    // =========================

    private Locator signInButton;
    private Locator signUp;

    // =========================
    // Register Your Account Locators
    // =========================

    private Locator continueBox;
    private Locator agentNumber;
    private Locator agentTaxIdNumber;

    // =========================
    // Modal Locators
    // =========================

    private Locator questionBox1;
    private Locator questionBox2;
    private Locator cancelButton;

    // =========================
    // Constructor
    // =========================

    public Home(Page page) {
        this.page = page;

        // Home Page
        this.search = page.locator("#search");

        this.getQuote = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Get A Quote")
                        .setExact(true));

        this.quoteHeaderCta = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("get a quote").setExact(true));

        this.agentLogin = page.locator(".text-block-2");

        this.forHomeowners = page.locator("id=w-dropdown-toggle-0");

        this.floridaPeninsulaLogo = page.locator(
                        "img[src*='Florida%20Peninsula.svg']")
                .first();

        this.edisonLogo = page.locator(
                        "img[src*='Edison%20Insurance%20Company.svg']")
                .first();

        this.ovationLogo = page.locator(
                        "img[src*='OvationR-Logo-Horizontal-Color-ForOnLight-large.webp']")
                .first();

        this.findAnAgent = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Find An Agent")
                        .setExact(true));

        // Agent Login / Sign Up
        this.signInButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Sign In"));

        this.signUp = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Register Your Account"));

        // Register Your Account
        this.continueBox = page.getByText("Continue");

        this.agentNumber = page.locator("#dnn_ctr1798_Default_tbAgentID");

        this.agentTaxIdNumber = page.locator("#dnn_ctr1798_Default_tbTaxID");

        // Modals
        this.questionBox1 = page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions()
                                .setName(""))
                .first();

        this.questionBox2 = page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions()
                                .setName(""))
                .nth(1);

        this.cancelButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("×"));
    }

    // =========================
    // Navigation
    // =========================

    public void navigate() {
        page.navigate("https://www.windwardrisk.com/");
    }

    // =========================
    // Home Page Actions
    // =========================

    public void search(String text) {
        search.fill(text);
        search.press("Enter");
    }

    public void clickGetQuote() {
        getQuote.click();
    }

    public void getQuoteHeaderCta(){
        quoteHeaderCta.click();

    }

    public void clickAgentLogin() {
        agentLogin.click();
    }

    public void clickOnForHomeOwners() {
        forHomeowners.click();
    }

    public void findAnAgentButton() {
        findAnAgent.click();
    }

    // =========================
    // Home Page Validations
    // =========================

    public void validateLogosAreVisible() {
        floridaPeninsulaLogo.scrollIntoViewIfNeeded();

        assertThat(floridaPeninsulaLogo).isVisible();
        assertThat(edisonLogo).isVisible();
        assertThat(ovationLogo).isVisible();
    }

    public void validateHeaderNavigationVisible() {
        assertThat(getQuote).isVisible();
        assertThat(agentLogin).isVisible();
        assertThat(findAnAgent).isVisible();
    }

    // =========================
    // Agent Login Actions
    // =========================

    public String enterEmail() {
        String email = "testuser" + System.currentTimeMillis() + "@gmail.com";

        page.getByRole(AriaRole.TEXTBOX,
                        new Page.GetByRoleOptions()
                                .setName("Username"))
                .fill(email);

        return email;
    }

    public String generateRandomPassword() {
        String password = "Test@" + System.currentTimeMillis();

        page.getByRole(AriaRole.TEXTBOX,
                        new Page.GetByRoleOptions()
                                .setName("Password"))
                .fill(password);

        return password;
    }

    public void singInCta() {
        signInButton.click();

    }

    public void signUpCta() {
        signUp.click();
    }

    // =========================
    // Register Your Account Actions
    // =========================

    public void registerYourAccount() {
        int agentNumbers = (int) System.currentTimeMillis();
        String enterAgent = String.valueOf((agentNumbers));

        agentNumber.fill(String.valueOf(agentNumbers));
        continueBox.click();
    }

    public void taxId() {
        int agentTaxId = (int) System.currentTimeMillis();
        String enterAgent = String.valueOf((agentTaxId));

        agentTaxIdNumber.fill(String.valueOf(agentTaxId));
        continueBox.click();
    }

    // =========================
    // Modal Actions
    // =========================

    public void questionMarkBox1() {
        questionBox1.click();
    }

    public void questionMarkBox2() {
        questionBox2.click();
    }

    public void valCancelButton() {
        cancelButton.click();
    }



}