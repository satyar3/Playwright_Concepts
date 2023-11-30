package com.qa.playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class LoginStorage {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://orangehrm.com/orangehtm-30-day-trial/");
        page.click("a:text(sign in)");
        page.fill("#email","test@mail.com");
        page.fill("#password","test@mail.com");
        page.click("#submit");

        //No need to login to the app again and again
        //1 - store the session details
        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));

        //2- Read the details from the storage file
        Playwright playwright1 = Playwright.create();
        Browser browser1 = playwright1.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext1 = browser1.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
        Page page1 = browserContext1.newPage();
        page1.navigate("http://orangehrm.com/orangehtm-30-day-trial/");


        playwright.close();
    }
}
