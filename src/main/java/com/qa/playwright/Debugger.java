package com.qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Set env --> PWDEBUG=1
 *
 * or
 *
 * page.pause();
 *
 */

public class Debugger {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setChannel("chrome");

            launchOptions.setHeadless(false);
            Browser browser = playwright.chromium().launch(launchOptions);
            Page page = browser.newPage();
            page.navigate("https://google.com");

            String pageTitle = page.title();
            System.out.println("Current Page title is : "+pageTitle);

            //This line of Code will bring the debugger if the env varibale is not set as PWDEBUG=1
            page.pause();

            page.fill("textarea[name='q']", "Satya");
            page.click("//input[@name='btnK']");

            page.close();
        }
    }
}