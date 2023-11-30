package com.qa.playwright;

import com.microsoft.playwright.*;

public class RelativeLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://books-pwakit.appspot.com");

        page.locator("div[something]:left-of(:text('Joe.Root'))").textContent();
        //td:right-of(:text('some_text'))
        //td:above(:text('some_text'))
        //td:below(:text('some_text'))
        //td:below(label:text('some_text'))
        //td:near(:text('some_text'))
        //td:near(:text('some_text'),120) --> matches a locator that is most 120 pixels away from the element

        //button >> nth=0 //first
        //button >> nth=-1 //last
        //div.footer-links li a >> nth=0
        //div.footer-links li a >> nth=-1

        playwright.close();
    }
}
