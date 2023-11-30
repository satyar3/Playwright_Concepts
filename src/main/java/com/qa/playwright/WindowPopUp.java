package com.qa.playwright;

import com.microsoft.playwright.*;

public class WindowPopUp {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext b1 = browser.newContext();
            BrowserContext b2 = browser.newContext();

            Page page1 = b1.newPage();
            page1.navigate("https://google.com");
            Page page2 = page1.waitForPopup(() -> page1.click("locator of the link which will open a new pop up" +
                    " e.g. img[@text='jkfkjdlsd']"));

            page2.waitForLoadState();

            //If you want to open a new blank window
            page1.click("a[target='_blank']");
            page2.waitForLoadState();

            System.out.println("parent : "+page1.title());
            page2.close();
            System.out.println("child : "+page2.title());
            page1.close();

            b1.close();
            b2.close();


            browser.close();
            //playwright.close();
        }
    }
}


