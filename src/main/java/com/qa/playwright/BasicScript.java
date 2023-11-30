package com.qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicScript {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)/*.setSlowMo(50)*/);
            Page page = browser.newPage();
            page.navigate("https://google.com");

            String pageTitle = page.title();
            System.out.println("Current Page title is : "+pageTitle);

            page.fill("textarea[name='q']", "Satya");
            page.click("//input[@name='btnK']");

            page.close();
        }
    }
}