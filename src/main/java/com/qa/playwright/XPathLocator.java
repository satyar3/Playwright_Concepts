package com.qa.playwright;

import com.microsoft.playwright.*;

public class XPathLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://orangehrm.com/orangehtm-30-day-trial/");


        //Xpath
        Locator locator = page.locator("xpath=(//table[@id='34'])[1]");
        //Locator locator = page.locator("(//table[@id='34'])[last]");

        playwright.close();
    }
}
