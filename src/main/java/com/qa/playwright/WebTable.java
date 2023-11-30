package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class WebTable {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://orangehrm.com/orangehtm-30-day-trial/");

        Locator locator = page.locator("table#example tr");
        locator.locator(":scope", new Locator.LocatorOptions().setHasText("Name Something"))
                        .locator(".select-checkbox")
                                .click();


        playwright.close();
    }
}
