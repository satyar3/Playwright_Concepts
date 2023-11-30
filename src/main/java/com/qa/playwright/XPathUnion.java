package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class XPathUnion {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://orangehrm.com/orangehtm-30-day-trial/");


        //Xpath union
        Locator locator = page.locator("//[text()='Sign In'] | [text()='Log In']");

        playwright.close();
    }
}
