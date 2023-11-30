package com.qa.playwright;

import com.microsoft.playwright.*;

public class ReactBasedSelector {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://books-pwakit.appspot.com");

        page.locator("_react=p[name='email']").textContent();

        playwright.close();
    }
}
