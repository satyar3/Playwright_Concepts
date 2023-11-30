package com.qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class LaunchOptions {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setChannel("chrome");
            //launchOptions.setChannel("msedge");
            launchOptions.setHeadless(false);
            Browser browser = playwright.chromium().launch(launchOptions);
            Page pageContext = browser.newPage();
            pageContext.navigate("https://google.com");

            String pageTitle = pageContext.title();
            System.out.println("Current Page title is : "+pageTitle);

            pageContext.fill("textarea[name='q']", "Satya");
            pageContext.click("//input[@name='btnK']");

            pageContext.close();
        }
    }
}