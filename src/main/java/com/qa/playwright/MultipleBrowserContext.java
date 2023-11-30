package com.qa.playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class MultipleBrowserContext {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context1 = browser.newContext();
            BrowserContext context2 = browser.newContext();

            /*// Start tracing before creating / navigating a pageContext1.
            context1.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));*/

            Page pageContext1 = context1.newPage();
            pageContext1.navigate("https://google.com");
            String pageTitle1 = pageContext1.title();
            System.out.println("Current Page title is : "+pageTitle1);

            Page pageContext2 = context2.newPage();
            pageContext2.navigate("https://playwright.dev");
            String pageTitle2 = pageContext2.title();
            System.out.println("Current Page title is : "+pageTitle2);

            pageContext1.fill("textarea[name='q']", "Satya");
            pageContext1.click("//input[@name='btnK']");

            /*// Stop tracing and export it into a zip archive.
            context1.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));*/




        }
    }
}