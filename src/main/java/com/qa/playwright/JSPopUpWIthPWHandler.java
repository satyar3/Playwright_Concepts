package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class JSPopUpWIthPWHandler {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            //This is the event handler or a listener for the specific page object and acts on all dialogs
            //Below snippet is not mandatory as by default it'll be handled in playwright
            page.onDialog(dialog -> {
                System.out.println(dialog.message());
                dialog.accept();
                //dialog.accept("Text to be entered in the prompt");
                //dialog.dismiss();
            });

            page.navigate("https://google.com");


            page.close();
            browser.close();
            //playwright.close();
        }
    }
}