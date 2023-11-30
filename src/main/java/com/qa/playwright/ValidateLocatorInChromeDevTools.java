package com.qa.playwright;

import com.microsoft.playwright.*;


public class ValidateLocatorInChromeDevTools {
    public static void main(String[] args) throws InterruptedException {

        //Open desired website in the cli mode using codegen:
        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://google.com"

        /**
         *
         * 1 - Go to console tab
         * 2 - Type : playwright.$("<Locator></Locator>")
         *
         * if you want to exact locator in dom
         * 2 - playwright.inspect("<Locator/>")
         *
         *
         * $ -> single element
         * $$ -> Multiple elements
         *
         */

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