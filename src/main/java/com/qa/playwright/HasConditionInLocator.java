package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class HasConditionInLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://orangehrm.com/orangehtm-30-day-trial/");


        //Find the parent element having a specific child element i.e. some other element as filtering criteria
        Locator locator = page.locator("select[name='country']:has(option[value='India'])");
        List<String> strings = locator.allTextContents();

        //or
        //page.locator("button >> visible=trues").textContent();
        //page.locator("xpath=//button >> visible=trues").textContent();

        playwright.close();
    }
}
