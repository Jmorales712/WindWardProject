package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Home {


    //Home Page Locators
    private Page page;
    private Locator search;
    private Locator getQuote;
    private Locator agentLogin;
    private Locator forHomeowners;
    private Locator floridaPeninsulaLogo;
    private Locator edisonLogo;
    private Locator ovationLogo;
    private Locator findAnAgent;

    //Agent Login/SignUp Locators
    private Locator signInButton;
    private Locator signUp;

    // Register Your Account - Agent sign up

    private Locator continueBox;
    private Locator agentNumber;
    private Locator agentTaxIdNumber;

    private Locator questionBox2;
    private Locator questionBox1;

    private Locator cancelButton;


    // Elements on the home page
    public Home(Page page) {
        this.page = page;

        // Home Page ///
        this.search = page.locator("#search"); // desktop search box

        this.getQuote = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Get A Quote")
                        .setExact(true));

        this.agentLogin = page.locator(".text-block-2");

        this.forHomeowners = page.locator("id=w-dropdown-toggle-0");

        this.floridaPeninsulaLogo = page.locator
                ("img[src*='Florida%20Peninsula.svg']")
                .first();

        this.edisonLogo = page.locator
                ("img[src*='Edison%20Insurance%20Company.svg']")
                    .first();

        this.ovationLogo = page.locator
                ("img[src*='OvationR-Logo-Horizontal-Color-ForOnLight-large.webp']")
                    .first();

        this.findAnAgent = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Find An Agent").setExact(true));

        // AgentLoginPage ///
        this.signInButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Sign In"));

        this.signUp= page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Register Your Account"));

        //Agent Sign up //

        this.continueBox = page.getByText("Continue");

        this.agentNumber = page.locator("#dnn_ctr1798_Default_tbAgentID");

        this.agentTaxIdNumber = page.locator("#dnn_ctr1798_Default_tbTaxID");

        this.questionBox2 = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("")).nth(1);

        this.questionBox1 = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("")).first();

        this.cancelButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("×"));

    }

    //Open the Windward URL
    public void navigate() {
        page.navigate("https://www.windwardrisk.com/");

    }

    // Enter the test case string into the search box and click continue.
    public void search(String text) {
        search.fill(text);
        search.press("Enter");

    }

    // Get a Quote Button
    public void clickGetQuote() {
        getQuote.click();

    }

    // Agent Login Button

    public void clickAgentLogin() {
        agentLogin.click();

    }

    // For HomeOwners Dropdown
    public void clickOnForHomeOwners() {
        forHomeowners.click();

    }

    public void validateLogosAreVisible() {
        floridaPeninsulaLogo.scrollIntoViewIfNeeded();
        assertThat(floridaPeninsulaLogo).isVisible();
        assertThat(edisonLogo).isVisible();
        assertThat(ovationLogo).isVisible();
    }

    public void findAnAgentButton (){
        findAnAgent.click();

        }

    public String generateRandomPassword() {
        String password = "Test@" + System.currentTimeMillis();

        page.getByRole(AriaRole.TEXTBOX,
                        new Page.GetByRoleOptions().setName("Password"))
                .fill(password);

        return password;
    }

        public String enterEmail() {
            String email = "testuser" + System.currentTimeMillis() + "@gmail.com";

            page.getByRole(AriaRole.TEXTBOX,
                            new Page.GetByRoleOptions().setName("Username"))
                    .fill(email);
            return email;
        }

        public void singInCta () {
        signInButton.click();

        }

        public void signUpCta(){
        signUp.click();

        }

        public void registerYourAccount (){

        int agentNumbers = (int) System.currentTimeMillis();
        String enterAgent = String.valueOf((agentNumbers));

        agentNumber.fill(String.valueOf(agentNumbers));
        continueBox.click();

        }

        public void taxId (){
            int agentTaxId = (int) System.currentTimeMillis();
            String enterAgent = String.valueOf((agentTaxId));

            agentTaxIdNumber.fill(String.valueOf(agentTaxId));
            continueBox.click();

        }

        public void questionMarkBox1 (){
        questionBox1.click();

        }

        public void questionMarkBox2(){
        questionBox2.click();

        }

        public void valCancelButton (){
        cancelButton.click();

        }
}



