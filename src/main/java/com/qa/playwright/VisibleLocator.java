package com.qa.playwright;

import com.microsoft.playwright.*;

public class VisibleLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://books-pwakit.appspot.com");

        page.locator("button:visible").textContent();

        //or
        //page.locator("button >> visible=trues").textContent();
        //page.locator("xpath=//button >> visible=trues").textContent();

        playwright.close();
    }
}
