package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class ShadowDOM {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://books-pwakit.appspot.com");

        //give CSS selector of the parent node and the css of the destinated node
        page.locator("book-app[apptitle='BOOKS'] #input").fill("TEST");

        playwright.close();
    }
}
