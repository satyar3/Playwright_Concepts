package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class TextSelector {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://google.com");
        Locator locator = page.locator("text=Google Search");

        List<Locator> all = locator.all();

        //:has-text='some text'

        all.forEach(locator1 -> System.out.println(locator1));
        locator.first().click();
    }
}
