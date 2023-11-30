package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

//Locator in Playwright is same as Webelement unlike selenium where xpath and css etc comes into picture
public class LocatorEx {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://google.com");
            page.fill("textarea[name='q']", "Satya");

            //Single Locator
            Locator singleLocator = page.locator("text = Images");
            singleLocator.click();

            Thread.sleep(3000);
            page.goBack();

            Thread.sleep(3000);

            //Multiple Locator
            Locator locator = page.locator("text = Google Search");
            locator.count();
            List<String> strings = locator.allTextContents();
            System.out.println("Text : "+strings);

            List<Locator> multiLocator = locator.all();
            System.out.println("Locators : "+multiLocator);
        }
    }
}